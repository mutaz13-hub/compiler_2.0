# Undefined variable
print(x)

# Type error
y = 10 + "hello"

# Type mismatched
z = 5
z = "world"

# Missing flask variable
from flask import Flask
# APP and request are missing here

# Scope error
def my_func():
    internal_var = 10

print(internal_var)
