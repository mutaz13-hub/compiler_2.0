from flask import Flask, request, redirect, url_for, make_response
from flask import render_template_string
import json
import os

APP = Flask(__name__)

TEMPLATE_FILE = "products.html"
DATA_FILE = "products_data.json"

# مساعدة: قراءة/كتابة بيانات بسيطة في JSON (قائمة منتجات)
def load_products():
    if not os.path.exists(DATA_FILE):
        # عناصر مثال لإظهار الواجهة لأول مرة
        sample = [
            {"id": 1, "name": "كرسي مريح", "price": 79.99, "image": "https://via.placeholder.com/600x400?text=Chair", "description": "كرسي مريح مناسِب للمكتب." },
            {"id": 2, "name": "طاولة خشب", "price": 149.00, "image": "https://via.placeholder.com/600x400?text=Table", "description": "طاولة طعام من خشب البلوط." }
        ]
        save_products(sample)
        return sample
    with open(DATA_FILE, "r", encoding="utf-8") as f:
        try:
            return json.load(f)
        except:
            return []

def save_products(products):
    with open(DATA_FILE, "w", encoding="utf-8") as f:
        json.dump(products, f, ensure_ascii=False, indent=2)

def next_id(products):
    if not products:
        return 1
    return max(p.get("id",0) for p in products)+1

# قراءة قالب HTML (يتضمن Jinja placeholders)
with open(TEMPLATE_FILE, "r", encoding="utf-8") as f:
    TEMPLATE_STR = f.read()

@APP.route("/", methods=["GET"])
def index():
    q = (request.args.get("q") or "").strip().lower()
    products = load_products()
    if q:
        products = [p for p in products if q in (p.get("name","").lower() + " " + (p.get("description") or "").lower())]
    # render_template_string يسمح بتمرير الطلب request أيضاً (للقيم في الحقل)
    return render_template_string(TEMPLATE_STR, products=products, product=None, show_add=False, request=request)

@APP.route("/add", methods=["GET","POST"])
def add_product():
    if request.method == "POST":
        name = request.form.get("name","").strip()
        price = request.form.get("price","0").strip()
        image = request.form.get("image","").strip() or "https://via.placeholder.com/600x400?text=No+Image"
        description = request.form.get("description","").strip()

        try:
            price_val = float(price)
        except:
            price_val = 0.0

        products = load_products()
        new = {
            "id": next_id(products),"name": name or f"منتج {next_id(products)}","price": round(price_val,2),"image": image,"description": description
        }
        products.append(new)
        save_products(products)
        return redirect(url_for("index"))
        
    # GET -> عرض النموذج
    return render_template_string(TEMPLATE_STR, products=[], product=None, show_add=True, request=request)

@APP.route("/delete/<int:pid>", methods=["POST"])
def delete_product(pid):
    products = load_products()
    new_products = [p for p in products if int(p.get("id", 0)) != pid]

    if len(new_products) == len(products):
        return make_response("المنتج غير موجود", 404)

    save_products(new_products)
    return redirect(url_for("index"))

@APP.route("/product/<int:pid>")
def product_detail(pid):
    products = load_products()
    prod = next((p for p in products if int(p.get("id",0))==pid), None)
    if not prod:
        return make_response("المنتج غير موجود", 404)
    return render_template_string(TEMPLATE_STR, products=[], product=prod, show_add=False, request=request)

if __name__ == "__main__":
    APP.run(debug=True, host="0.0.0.0", port=5000)
