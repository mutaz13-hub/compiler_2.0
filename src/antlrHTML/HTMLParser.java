// Generated from C:/Users/Mutaz13/Desktop/compiler_2.0/compiler_2.0/src/HTMLParser.g4 by ANTLR 4.13.2

package antlrHTML;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class HTMLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LBRACE=1, RBRACE=2, LPAREN=3, RPAREN=4, LBRACK=5, RBRACK=6, SEMI=7, COLON=8, 
		COMMA=9, DOT=10, EQ=11, PLUS=12, MINUS=13, STAR=14, SLASH=15, PIPE=16, 
		UNDERSCORE=17, QUESTION=18, AND=19, OR=20, TAG_OPEN=21, TAG_CLOSE=22, 
		HASH=23, TILDE=24, TILDE_EQUALS=25, PIPE_EQUALS=26, CARET_EQUALS=27, DOLLAR_EQUALS=28, 
		STAR_EQUALS=29, DOUBLE_COLON=30, NOT=31, NUMBER=32, VAR=33, ID=34, WS=35, 
		NEWLINE=36, DOUBLE_QUOTE_STRING=37, HTML_COMMENT=38, STYLE_COMMENT=39, 
		IMPORTANT=40, URL=41, AT_RULE=42, IDENT=43, VAR_START=44, VAR_END=45, 
		BLOCK_START=46, BLOCK_END=47, COMMENT_START=48, COMMENT_END=49, IF=50, 
		ELIF=51, ELSE=52, ENDIF=53, FOR=54, IN=55, ENDFOR=56, SET=57, BLOCK=58, 
		ENDBLOCK=59, INCLUDE=60, EXTENDS=61;
	public static final int
		RULE_root = 0, RULE_html_content = 1, RULE_tag = 2, RULE_tag_content = 3, 
		RULE_ident = 4, RULE_style = 5, RULE_rule = 6, RULE_selector = 7, RULE_simpleSelector = 8, 
		RULE_typeSelector = 9, RULE_universal = 10, RULE_class = 11, RULE_attrib = 12, 
		RULE_combinator = 13, RULE_declaration = 14, RULE_property = 15, RULE_value = 16, 
		RULE_valuePart = 17, RULE_atRule = 18, RULE_atRuleBody = 19, RULE_jinja2 = 20, 
		RULE_statement = 21, RULE_stmt = 22, RULE_expr = 23, RULE_expr_content = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "html_content", "tag", "tag_content", "ident", "style", "rule", 
			"selector", "simpleSelector", "typeSelector", "universal", "class", "attrib", 
			"combinator", "declaration", "property", "value", "valuePart", "atRule", 
			"atRuleBody", "jinja2", "statement", "stmt", "expr", "expr_content"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "'['", "']'", "';'", "':'", "','", 
			"'.'", "'='", "'+'", "'-'", "'*'", "'/'", "'|'", "'_'", "'?'", "'and'", 
			"'or'", "'<'", "'>'", "'#'", "'~'", "'~='", "'|='", "'^='", "'$='", "'*='", 
			"'::'", "'not'", null, null, null, null, "'\\r\\n'", null, null, null, 
			null, null, null, null, "'{{'", "'}}'", "'{%'", "'%}'", "'{#'", "'#}'", 
			"'if'", "'elif'", "'else'", "'endif'", "'for'", "'in'", "'endfor'", "'set'", 
			"'block'", "'endblock'", "'include'", "'extends'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LBRACE", "RBRACE", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "SEMI", 
			"COLON", "COMMA", "DOT", "EQ", "PLUS", "MINUS", "STAR", "SLASH", "PIPE", 
			"UNDERSCORE", "QUESTION", "AND", "OR", "TAG_OPEN", "TAG_CLOSE", "HASH", 
			"TILDE", "TILDE_EQUALS", "PIPE_EQUALS", "CARET_EQUALS", "DOLLAR_EQUALS", 
			"STAR_EQUALS", "DOUBLE_COLON", "NOT", "NUMBER", "VAR", "ID", "WS", "NEWLINE", 
			"DOUBLE_QUOTE_STRING", "HTML_COMMENT", "STYLE_COMMENT", "IMPORTANT", 
			"URL", "AT_RULE", "IDENT", "VAR_START", "VAR_END", "BLOCK_START", "BLOCK_END", 
			"COMMENT_START", "COMMENT_END", "IF", "ELIF", "ELSE", "ENDIF", "FOR", 
			"IN", "ENDFOR", "SET", "BLOCK", "ENDBLOCK", "INCLUDE", "EXTENDS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "HTMLParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HTMLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(HTMLParser.EOF, 0); }
		public List<Html_contentContext> html_content() {
			return getRuleContexts(Html_contentContext.class);
		}
		public Html_contentContext html_content(int i) {
			return getRuleContext(Html_contentContext.class,i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 92376188081698L) != 0)) {
				{
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(50);
					html_content();
					}
					}
					setState(53); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 92376188081698L) != 0) );
				}
			}

			setState(57);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Html_contentContext extends ParserRuleContext {
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public Jinja2Context jinja2() {
			return getRuleContext(Jinja2Context.class,0);
		}
		public Html_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_html_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterHtml_content(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitHtml_content(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHtml_content(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Html_contentContext html_content() throws RecognitionException {
		Html_contentContext _localctx = new Html_contentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_html_content);
		try {
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				tag();
				}
				break;
			case LBRACE:
			case LBRACK:
			case COMMA:
			case DOT:
			case PLUS:
			case STAR:
			case TAG_CLOSE:
			case HASH:
			case TILDE:
			case ID:
			case AT_RULE:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				style();
				}
				break;
			case VAR_START:
			case BLOCK_START:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				jinja2();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagContext extends ParserRuleContext {
		public TerminalNode TAG_OPEN() { return getToken(HTMLParser.TAG_OPEN, 0); }
		public Tag_contentContext tag_content() {
			return getRuleContext(Tag_contentContext.class,0);
		}
		public TerminalNode TAG_CLOSE() { return getToken(HTMLParser.TAG_CLOSE, 0); }
		public List<TerminalNode> SLASH() { return getTokens(HTMLParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(HTMLParser.SLASH, i);
		}
		public List<TerminalNode> ID() { return getTokens(HTMLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(HTMLParser.ID, i);
		}
		public TerminalNode COLON() { return getToken(HTMLParser.COLON, 0); }
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tag);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(TAG_OPEN);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SLASH) {
				{
				setState(65);
				match(SLASH);
				}
			}

			setState(68);
			tag_content();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SLASH) {
				{
				setState(69);
				match(SLASH);
				}
			}

			setState(72);
			match(TAG_CLOSE);
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(73);
					match(ID);
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(79);
				match(COLON);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Tag_contentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(HTMLParser.ID, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public Tag_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterTag_content(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitTag_content(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitTag_content(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tag_contentContext tag_content() throws RecognitionException {
		Tag_contentContext _localctx = new Tag_contentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tag_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(ID);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 154618824704L) != 0)) {
				{
				{
				setState(83);
				ident();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(HTMLParser.ID, 0); }
		public TerminalNode EQ() { return getToken(HTMLParser.EQ, 0); }
		public TerminalNode DOUBLE_QUOTE_STRING() { return getToken(HTMLParser.DOUBLE_QUOTE_STRING, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ident);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 154618824704L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StyleContext extends ParserRuleContext {
		public RuleContext rule_() {
			return getRuleContext(RuleContext.class,0);
		}
		public AtRuleContext atRule() {
			return getRuleContext(AtRuleContext.class,0);
		}
		public StyleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_style; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterStyle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitStyle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitStyle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleContext style() throws RecognitionException {
		StyleContext _localctx = new StyleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_style);
		try {
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
			case LBRACK:
			case COMMA:
			case DOT:
			case PLUS:
			case STAR:
			case TAG_CLOSE:
			case HASH:
			case TILDE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				rule_();
				}
				break;
			case AT_RULE:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				atRule();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RuleContext extends ParserRuleContext {
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(HTMLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(HTMLParser.RBRACE, 0); }
		public List<TerminalNode> ID() { return getTokens(HTMLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(HTMLParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(HTMLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(HTMLParser.COMMA, i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleContext rule_() throws RecognitionException {
		RuleContext _localctx = new RuleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			selector();
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(96);
				match(ID);
				}
				break;
			}
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(99);
				match(COMMA);
				}
				break;
			}
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(102);
				match(ID);
				}
				break;
			}
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(105);
				match(ID);
				}
				break;
			}
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(108);
				match(COMMA);
				}
			}

			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(111);
				match(ID);
				}
				break;
			}
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(114);
				match(ID);
				}
			}

			setState(117);
			match(LBRACE);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR || _la==ID) {
				{
				{
				setState(118);
				declaration();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectorContext extends ParserRuleContext {
		public List<SimpleSelectorContext> simpleSelector() {
			return getRuleContexts(SimpleSelectorContext.class);
		}
		public SimpleSelectorContext simpleSelector(int i) {
			return getRuleContext(SimpleSelectorContext.class,i);
		}
		public List<CombinatorContext> combinator() {
			return getRuleContexts(CombinatorContext.class);
		}
		public CombinatorContext combinator(int i) {
			return getRuleContext(CombinatorContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(HTMLParser.COMMA, 0); }
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_selector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			simpleSelector();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 20975616L) != 0)) {
				{
				{
				setState(127);
				combinator();
				setState(128);
				simpleSelector();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(135);
				match(COMMA);
				setState(136);
				selector();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleSelectorContext extends ParserRuleContext {
		public TypeSelectorContext typeSelector() {
			return getRuleContext(TypeSelectorContext.class,0);
		}
		public UniversalContext universal() {
			return getRuleContext(UniversalContext.class,0);
		}
		public List<TerminalNode> HASH() { return getTokens(HTMLParser.HASH); }
		public TerminalNode HASH(int i) {
			return getToken(HTMLParser.HASH, i);
		}
		public List<ClassContext> class_() {
			return getRuleContexts(ClassContext.class);
		}
		public ClassContext class_(int i) {
			return getRuleContext(ClassContext.class,i);
		}
		public List<AttribContext> attrib() {
			return getRuleContexts(AttribContext.class);
		}
		public AttribContext attrib(int i) {
			return getRuleContext(AttribContext.class,i);
		}
		public SimpleSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleSelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterSimpleSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitSimpleSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitSimpleSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleSelectorContext simpleSelector() throws RecognitionException {
		SimpleSelectorContext _localctx = new SimpleSelectorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_simpleSelector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
			case LBRACK:
			case COMMA:
			case DOT:
			case PLUS:
			case TAG_CLOSE:
			case HASH:
			case TILDE:
			case ID:
				{
				setState(139);
				typeSelector();
				}
				break;
			case STAR:
				{
				setState(140);
				universal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8389664L) != 0)) {
				{
				setState(146);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case HASH:
					{
					setState(143);
					match(HASH);
					}
					break;
				case DOT:
					{
					setState(144);
					class_();
					}
					break;
				case LBRACK:
					{
					setState(145);
					attrib();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSelectorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(HTMLParser.ID, 0); }
		public TypeSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterTypeSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitTypeSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitTypeSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSelectorContext typeSelector() throws RecognitionException {
		TypeSelectorContext _localctx = new TypeSelectorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeSelector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(151);
				match(ID);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UniversalContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(HTMLParser.STAR, 0); }
		public UniversalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_universal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterUniversal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitUniversal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitUniversal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UniversalContext universal() throws RecognitionException {
		UniversalContext _localctx = new UniversalContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_universal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(STAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(HTMLParser.DOT, 0); }
		public TerminalNode ID() { return getToken(HTMLParser.ID, 0); }
		public ClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassContext class_() throws RecognitionException {
		ClassContext _localctx = new ClassContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_class);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(DOT);
			setState(157);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttribContext extends ParserRuleContext {
		public AttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrib; }
	 
		public AttribContext() { }
		public void copyFrom(AttribContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttribWithoutValueContext extends AttribContext {
		public TerminalNode LBRACK() { return getToken(HTMLParser.LBRACK, 0); }
		public TerminalNode ID() { return getToken(HTMLParser.ID, 0); }
		public TerminalNode RBRACK() { return getToken(HTMLParser.RBRACK, 0); }
		public AttribWithoutValueContext(AttribContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterAttribWithoutValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitAttribWithoutValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitAttribWithoutValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttribWithValueContext extends AttribContext {
		public TerminalNode LBRACK() { return getToken(HTMLParser.LBRACK, 0); }
		public List<TerminalNode> ID() { return getTokens(HTMLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(HTMLParser.ID, i);
		}
		public TerminalNode RBRACK() { return getToken(HTMLParser.RBRACK, 0); }
		public TerminalNode EQ() { return getToken(HTMLParser.EQ, 0); }
		public TerminalNode TILDE_EQUALS() { return getToken(HTMLParser.TILDE_EQUALS, 0); }
		public TerminalNode PIPE_EQUALS() { return getToken(HTMLParser.PIPE_EQUALS, 0); }
		public TerminalNode CARET_EQUALS() { return getToken(HTMLParser.CARET_EQUALS, 0); }
		public TerminalNode DOLLAR_EQUALS() { return getToken(HTMLParser.DOLLAR_EQUALS, 0); }
		public TerminalNode STAR_EQUALS() { return getToken(HTMLParser.STAR_EQUALS, 0); }
		public AttribWithValueContext(AttribContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterAttribWithValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitAttribWithValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitAttribWithValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttribContext attrib() throws RecognitionException {
		AttribContext _localctx = new AttribContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_attrib);
		int _la;
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new AttribWithValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(LBRACK);
				setState(160);
				match(ID);
				{
				setState(161);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1040189440L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				{
				setState(162);
				match(ID);
				}
				}
				setState(164);
				match(RBRACK);
				}
				break;
			case 2:
				_localctx = new AttribWithoutValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				match(LBRACK);
				setState(166);
				match(ID);
				setState(167);
				match(RBRACK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CombinatorContext extends ParserRuleContext {
		public CombinatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_combinator; }
	 
		public CombinatorContext() { }
		public void copyFrom(CombinatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdjacentSiblingCombinatorContext extends CombinatorContext {
		public TerminalNode PLUS() { return getToken(HTMLParser.PLUS, 0); }
		public AdjacentSiblingCombinatorContext(CombinatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterAdjacentSiblingCombinator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitAdjacentSiblingCombinator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitAdjacentSiblingCombinator(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ChildCombinatorContext extends CombinatorContext {
		public TerminalNode TAG_CLOSE() { return getToken(HTMLParser.TAG_CLOSE, 0); }
		public ChildCombinatorContext(CombinatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterChildCombinator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitChildCombinator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitChildCombinator(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GeneralSiblingCombinatorContext extends CombinatorContext {
		public TerminalNode TILDE() { return getToken(HTMLParser.TILDE, 0); }
		public GeneralSiblingCombinatorContext(CombinatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterGeneralSiblingCombinator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitGeneralSiblingCombinator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitGeneralSiblingCombinator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CombinatorContext combinator() throws RecognitionException {
		CombinatorContext _localctx = new CombinatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_combinator);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_CLOSE:
				_localctx = new ChildCombinatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(TAG_CLOSE);
				}
				break;
			case PLUS:
				_localctx = new AdjacentSiblingCombinatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				match(PLUS);
				}
				break;
			case TILDE:
				_localctx = new GeneralSiblingCombinatorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				match(TILDE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
		public TerminalNode COLON() { return getToken(HTMLParser.COLON, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(HTMLParser.SEMI, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			property();
			setState(176);
			match(COLON);
			setState(177);
			value();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(178);
				match(SEMI);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyContext extends ParserRuleContext {
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
	 
		public PropertyContext() { }
		public void copyFrom(PropertyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentPropertyContext extends PropertyContext {
		public TerminalNode ID() { return getToken(HTMLParser.ID, 0); }
		public IdentPropertyContext(PropertyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterIdentProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitIdentProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitIdentProperty(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarPropertyContext extends PropertyContext {
		public TerminalNode VAR() { return getToken(HTMLParser.VAR, 0); }
		public VarPropertyContext(PropertyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterVarProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitVarProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitVarProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_property);
		try {
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new IdentPropertyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(ID);
				}
				break;
			case VAR:
				_localctx = new VarPropertyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				match(VAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public List<ValuePartContext> valuePart() {
			return getRuleContexts(ValuePartContext.class);
		}
		public ValuePartContext valuePart(int i) {
			return getRuleContext(ValuePartContext.class,i);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_value);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(185);
					valuePart();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(188); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValuePartContext extends ParserRuleContext {
		public ValuePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valuePart; }
	 
		public ValuePartContext() { }
		public void copyFrom(ValuePartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class QuestionValueContext extends ValuePartContext {
		public TerminalNode QUESTION() { return getToken(HTMLParser.QUESTION, 0); }
		public QuestionValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterQuestionValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitQuestionValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitQuestionValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UrlValueContext extends ValuePartContext {
		public TerminalNode URL() { return getToken(HTMLParser.URL, 0); }
		public TerminalNode RPAREN() { return getToken(HTMLParser.RPAREN, 0); }
		public List<TerminalNode> ID() { return getTokens(HTMLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(HTMLParser.ID, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(HTMLParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(HTMLParser.NUMBER, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(HTMLParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(HTMLParser.SLASH, i);
		}
		public List<TerminalNode> COLON() { return getTokens(HTMLParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(HTMLParser.COLON, i);
		}
		public List<TerminalNode> DOT() { return getTokens(HTMLParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(HTMLParser.DOT, i);
		}
		public List<TerminalNode> QUESTION() { return getTokens(HTMLParser.QUESTION); }
		public TerminalNode QUESTION(int i) {
			return getToken(HTMLParser.QUESTION, i);
		}
		public List<TerminalNode> EQ() { return getTokens(HTMLParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(HTMLParser.EQ, i);
		}
		public List<TerminalNode> AND() { return getTokens(HTMLParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(HTMLParser.AND, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(HTMLParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(HTMLParser.MINUS, i);
		}
		public List<TerminalNode> PLUS() { return getTokens(HTMLParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(HTMLParser.PLUS, i);
		}
		public UrlValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterUrlValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitUrlValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitUrlValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SlashValueContext extends ValuePartContext {
		public TerminalNode SLASH() { return getToken(HTMLParser.SLASH, 0); }
		public SlashValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterSlashValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitSlashValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitSlashValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StarValueContext extends ValuePartContext {
		public TerminalNode STAR() { return getToken(HTMLParser.STAR, 0); }
		public StarValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterStarValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitStarValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitStarValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DotValueContext extends ValuePartContext {
		public TerminalNode DOT() { return getToken(HTMLParser.DOT, 0); }
		public DotValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterDotValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitDotValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitDotValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleQuoteValueContext extends ValuePartContext {
		public TerminalNode DOUBLE_QUOTE_STRING() { return getToken(HTMLParser.DOUBLE_QUOTE_STRING, 0); }
		public DoubleQuoteValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterDoubleQuoteValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitDoubleQuoteValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitDoubleQuoteValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HashValueContext extends ValuePartContext {
		public TerminalNode HASH() { return getToken(HTMLParser.HASH, 0); }
		public HashValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterHashValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitHashValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitHashValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenValueContext extends ValuePartContext {
		public TerminalNode LPAREN() { return getToken(HTMLParser.LPAREN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(HTMLParser.RPAREN, 0); }
		public ParenValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterParenValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitParenValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitParenValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TildeValueContext extends ValuePartContext {
		public TerminalNode TILDE() { return getToken(HTMLParser.TILDE, 0); }
		public TildeValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterTildeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitTildeValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitTildeValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarValueContext extends ValuePartContext {
		public TerminalNode VAR() { return getToken(HTMLParser.VAR, 0); }
		public VarValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterVarValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitVarValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitVarValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualsValueContext extends ValuePartContext {
		public TerminalNode EQ() { return getToken(HTMLParser.EQ, 0); }
		public EqualsValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterEqualsValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitEqualsValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitEqualsValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CommaValueContext extends ValuePartContext {
		public TerminalNode COMMA() { return getToken(HTMLParser.COMMA, 0); }
		public CommaValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterCommaValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitCommaValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitCommaValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ColonValueContext extends ValuePartContext {
		public TerminalNode COLON() { return getToken(HTMLParser.COLON, 0); }
		public ColonValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterColonValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitColonValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitColonValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinusValueContext extends ValuePartContext {
		public TerminalNode MINUS() { return getToken(HTMLParser.MINUS, 0); }
		public MinusValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterMinusValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitMinusValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitMinusValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusValueContext extends ValuePartContext {
		public TerminalNode PLUS() { return getToken(HTMLParser.PLUS, 0); }
		public PlusValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterPlusValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitPlusValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitPlusValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImportantValueContext extends ValuePartContext {
		public TerminalNode IMPORTANT() { return getToken(HTMLParser.IMPORTANT, 0); }
		public ImportantValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterImportantValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitImportantValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitImportantValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentValueContext extends ValuePartContext {
		public TerminalNode ID() { return getToken(HTMLParser.ID, 0); }
		public IdentValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterIdentValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitIdentValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitIdentValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberValueContext extends ValuePartContext {
		public TerminalNode NUMBER() { return getToken(HTMLParser.NUMBER, 0); }
		public NumberValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterNumberValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitNumberValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitNumberValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterValueContext extends ValuePartContext {
		public TerminalNode TAG_OPEN() { return getToken(HTMLParser.TAG_OPEN, 0); }
		public GreaterValueContext(ValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterGreaterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitGreaterValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitGreaterValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuePartContext valuePart() throws RecognitionException {
		ValuePartContext _localctx = new ValuePartContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_valuePart);
		int _la;
		try {
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new IdentValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				match(ID);
				}
				break;
			case VAR:
				_localctx = new VarValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				match(VAR);
				}
				break;
			case NUMBER:
				_localctx = new NumberValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				match(NUMBER);
				}
				break;
			case HASH:
				_localctx = new HashValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
				match(HASH);
				}
				break;
			case IMPORTANT:
				_localctx = new ImportantValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(194);
				match(IMPORTANT);
				}
				break;
			case URL:
				_localctx = new UrlValueContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(195);
				match(URL);
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 21475671296L) != 0)) {
					{
					{
					setState(196);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 21475671296L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(201);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(202);
				match(RPAREN);
				}
				break;
			case LPAREN:
				_localctx = new ParenValueContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(203);
				match(LPAREN);
				setState(204);
				value();
				setState(205);
				match(RPAREN);
				}
				break;
			case COMMA:
				_localctx = new CommaValueContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(207);
				match(COMMA);
				}
				break;
			case DOT:
				_localctx = new DotValueContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(208);
				match(DOT);
				}
				break;
			case COLON:
				_localctx = new ColonValueContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(209);
				match(COLON);
				}
				break;
			case SLASH:
				_localctx = new SlashValueContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(210);
				match(SLASH);
				}
				break;
			case TAG_OPEN:
				_localctx = new GreaterValueContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(211);
				match(TAG_OPEN);
				}
				break;
			case PLUS:
				_localctx = new PlusValueContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(212);
				match(PLUS);
				}
				break;
			case MINUS:
				_localctx = new MinusValueContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(213);
				match(MINUS);
				}
				break;
			case STAR:
				_localctx = new StarValueContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(214);
				match(STAR);
				}
				break;
			case TILDE:
				_localctx = new TildeValueContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(215);
				match(TILDE);
				}
				break;
			case EQ:
				_localctx = new EqualsValueContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(216);
				match(EQ);
				}
				break;
			case QUESTION:
				_localctx = new QuestionValueContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(217);
				match(QUESTION);
				}
				break;
			case DOUBLE_QUOTE_STRING:
				_localctx = new DoubleQuoteValueContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(218);
				match(DOUBLE_QUOTE_STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtRuleContext extends ParserRuleContext {
		public TerminalNode AT_RULE() { return getToken(HTMLParser.AT_RULE, 0); }
		public AtRuleBodyContext atRuleBody() {
			return getRuleContext(AtRuleBodyContext.class,0);
		}
		public List<ValuePartContext> valuePart() {
			return getRuleContexts(ValuePartContext.class);
		}
		public ValuePartContext valuePart(int i) {
			return getRuleContext(ValuePartContext.class,i);
		}
		public List<TerminalNode> URL() { return getTokens(HTMLParser.URL); }
		public TerminalNode URL(int i) {
			return getToken(HTMLParser.URL, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(HTMLParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(HTMLParser.RPAREN, i);
		}
		public List<TerminalNode> ID() { return getTokens(HTMLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(HTMLParser.ID, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(HTMLParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(HTMLParser.NUMBER, i);
		}
		public AtRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterAtRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitAtRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitAtRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtRuleContext atRule() throws RecognitionException {
		AtRuleContext _localctx = new AtRuleContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_atRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(AT_RULE);
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3466066198280L) != 0)) {
				{
				setState(228);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(222);
					valuePart();
					}
					break;
				case 2:
					{
					setState(223);
					match(URL);
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NUMBER || _la==ID) {
						{
						setState(224);
						_la = _input.LA(1);
						if ( !(_la==NUMBER || _la==ID) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
					}

					setState(227);
					match(RPAREN);
					}
					break;
				}
				}
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(233);
			atRuleBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtRuleBodyContext extends ParserRuleContext {
		public AtRuleBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atRuleBody; }
	 
		public AtRuleBodyContext() { }
		public void copyFrom(AtRuleBodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtRuleWithoutBlockContext extends AtRuleBodyContext {
		public TerminalNode SEMI() { return getToken(HTMLParser.SEMI, 0); }
		public AtRuleWithoutBlockContext(AtRuleBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterAtRuleWithoutBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitAtRuleWithoutBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitAtRuleWithoutBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtRuleWithBlockContext extends AtRuleBodyContext {
		public TerminalNode LBRACE() { return getToken(HTMLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(HTMLParser.RBRACE, 0); }
		public List<RuleContext> rule_() {
			return getRuleContexts(RuleContext.class);
		}
		public RuleContext rule_(int i) {
			return getRuleContext(RuleContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<AtRuleContext> atRule() {
			return getRuleContexts(AtRuleContext.class);
		}
		public AtRuleContext atRule(int i) {
			return getRuleContext(AtRuleContext.class,i);
		}
		public AtRuleWithBlockContext(AtRuleBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterAtRuleWithBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitAtRuleWithBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitAtRuleWithBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtRuleBodyContext atRuleBody() throws RecognitionException {
		AtRuleBodyContext _localctx = new AtRuleBodyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_atRuleBody);
		int _la;
		try {
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				_localctx = new AtRuleWithBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				match(LBRACE);
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4423845697058L) != 0)) {
					{
					setState(239);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						setState(236);
						rule_();
						}
						break;
					case 2:
						{
						setState(237);
						declaration();
						}
						break;
					case 3:
						{
						setState(238);
						atRule();
						}
						break;
					}
					}
					setState(243);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(244);
				match(RBRACE);
				}
				break;
			case SEMI:
				_localctx = new AtRuleWithoutBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Jinja2Context extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Jinja2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinja2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterJinja2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitJinja2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitJinja2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jinja2Context jinja2() throws RecognitionException {
		Jinja2Context _localctx = new Jinja2Context(_ctx, getState());
		enterRule(_localctx, 40, RULE_jinja2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_statement);
		try {
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BLOCK_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				stmt();
				}
				break;
			case VAR_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public TerminalNode BLOCK_START() { return getToken(HTMLParser.BLOCK_START, 0); }
		public TerminalNode BLOCK_END() { return getToken(HTMLParser.BLOCK_END, 0); }
		public List<TerminalNode> ID() { return getTokens(HTMLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(HTMLParser.ID, i);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_stmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(BLOCK_START);
			setState(258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(255);
					match(ID);
					}
					} 
				}
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			setState(261);
			match(BLOCK_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TerminalNode VAR_START() { return getToken(HTMLParser.VAR_START, 0); }
		public TerminalNode VAR_END() { return getToken(HTMLParser.VAR_END, 0); }
		public List<Expr_contentContext> expr_content() {
			return getRuleContexts(Expr_contentContext.class);
		}
		public Expr_contentContext expr_content(int i) {
			return getRuleContext(Expr_contentContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(VAR_START);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 158935875960L) != 0)) {
				{
				{
				setState(264);
				expr_content();
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
			match(VAR_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_contentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(HTMLParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(HTMLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(HTMLParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(HTMLParser.COLON, 0); }
		public TerminalNode NUMBER() { return getToken(HTMLParser.NUMBER, 0); }
		public TerminalNode DOUBLE_QUOTE_STRING() { return getToken(HTMLParser.DOUBLE_QUOTE_STRING, 0); }
		public TerminalNode OR() { return getToken(HTMLParser.OR, 0); }
		public TerminalNode LBRACK() { return getToken(HTMLParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(HTMLParser.RBRACK, 0); }
		public TerminalNode PIPE() { return getToken(HTMLParser.PIPE, 0); }
		public TerminalNode TILDE() { return getToken(HTMLParser.TILDE, 0); }
		public TerminalNode TAG_CLOSE() { return getToken(HTMLParser.TAG_CLOSE, 0); }
		public Expr_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).enterExpr_content(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HTMLParserListener ) ((HTMLParserListener)listener).exitExpr_content(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HTMLParserVisitor ) return ((HTMLParserVisitor<? extends T>)visitor).visitExpr_content(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_contentContext expr_content() throws RecognitionException {
		Expr_contentContext _localctx = new Expr_contentContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expr_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 158935875960L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001=\u0113\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0004\u00004\b\u0000\u000b\u0000\f\u00005\u0003\u00008\b"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001?\b\u0001\u0001\u0002\u0001\u0002\u0003\u0002C\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002G\b\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"K\b\u0002\n\u0002\f\u0002N\t\u0002\u0001\u0002\u0003\u0002Q\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0005\u0003U\b\u0003\n\u0003\f\u0003X\t\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0003\u0005^\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0003\u0006b\b\u0006\u0001\u0006\u0003\u0006e\b\u0006"+
		"\u0001\u0006\u0003\u0006h\b\u0006\u0001\u0006\u0003\u0006k\b\u0006\u0001"+
		"\u0006\u0003\u0006n\b\u0006\u0001\u0006\u0003\u0006q\b\u0006\u0001\u0006"+
		"\u0003\u0006t\b\u0006\u0001\u0006\u0001\u0006\u0005\u0006x\b\u0006\n\u0006"+
		"\f\u0006{\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u0083\b\u0007\n\u0007\f\u0007\u0086\t\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u008a\b\u0007\u0001\b\u0001\b\u0003"+
		"\b\u008e\b\b\u0001\b\u0001\b\u0001\b\u0005\b\u0093\b\b\n\b\f\b\u0096\t"+
		"\b\u0001\t\u0003\t\u0099\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0003\f\u00a9\b\f\u0001\r\u0001\r\u0001\r\u0003\r\u00ae\b\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00b4\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u00b8\b\u000f\u0001\u0010\u0004\u0010\u00bb"+
		"\b\u0010\u000b\u0010\f\u0010\u00bc\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00c6\b\u0011"+
		"\n\u0011\f\u0011\u00c9\t\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u00dc\b\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u00e2\b\u0012\u0001\u0012\u0005\u0012\u00e5"+
		"\b\u0012\n\u0012\f\u0012\u00e8\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00f0\b\u0013\n\u0013"+
		"\f\u0013\u00f3\t\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00f7\b\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u00fd\b\u0015"+
		"\u0001\u0016\u0001\u0016\u0005\u0016\u0101\b\u0016\n\u0016\f\u0016\u0104"+
		"\t\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0005\u0017\u010a"+
		"\b\u0017\n\u0017\f\u0017\u010d\t\u0017\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0002L\u0102\u0000\u0019\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"0\u0000\u0005\u0003\u0000\u000b\u000b\"\"%%\u0002\u0000\u000b\u000b\u0019"+
		"\u001d\u0006\u0000\b\b\n\r\u000f\u000f\u0012\u0013  \"\"\u0002\u0000 "+
		" \"\"\t\u0000\u0003\u0006\b\b\u0010\u0010\u0014\u0014\u0016\u0016\u0018"+
		"\u0018  \"\"%%\u0135\u00007\u0001\u0000\u0000\u0000\u0002>\u0001\u0000"+
		"\u0000\u0000\u0004@\u0001\u0000\u0000\u0000\u0006R\u0001\u0000\u0000\u0000"+
		"\bY\u0001\u0000\u0000\u0000\n]\u0001\u0000\u0000\u0000\f_\u0001\u0000"+
		"\u0000\u0000\u000e~\u0001\u0000\u0000\u0000\u0010\u008d\u0001\u0000\u0000"+
		"\u0000\u0012\u0098\u0001\u0000\u0000\u0000\u0014\u009a\u0001\u0000\u0000"+
		"\u0000\u0016\u009c\u0001\u0000\u0000\u0000\u0018\u00a8\u0001\u0000\u0000"+
		"\u0000\u001a\u00ad\u0001\u0000\u0000\u0000\u001c\u00af\u0001\u0000\u0000"+
		"\u0000\u001e\u00b7\u0001\u0000\u0000\u0000 \u00ba\u0001\u0000\u0000\u0000"+
		"\"\u00db\u0001\u0000\u0000\u0000$\u00dd\u0001\u0000\u0000\u0000&\u00f6"+
		"\u0001\u0000\u0000\u0000(\u00f8\u0001\u0000\u0000\u0000*\u00fc\u0001\u0000"+
		"\u0000\u0000,\u00fe\u0001\u0000\u0000\u0000.\u0107\u0001\u0000\u0000\u0000"+
		"0\u0110\u0001\u0000\u0000\u000024\u0003\u0002\u0001\u000032\u0001\u0000"+
		"\u0000\u000045\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001"+
		"\u0000\u0000\u000068\u0001\u0000\u0000\u000073\u0001\u0000\u0000\u0000"+
		"78\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009:\u0005\u0000\u0000"+
		"\u0001:\u0001\u0001\u0000\u0000\u0000;?\u0003\u0004\u0002\u0000<?\u0003"+
		"\n\u0005\u0000=?\u0003(\u0014\u0000>;\u0001\u0000\u0000\u0000><\u0001"+
		"\u0000\u0000\u0000>=\u0001\u0000\u0000\u0000?\u0003\u0001\u0000\u0000"+
		"\u0000@B\u0005\u0015\u0000\u0000AC\u0005\u000f\u0000\u0000BA\u0001\u0000"+
		"\u0000\u0000BC\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DF\u0003"+
		"\u0006\u0003\u0000EG\u0005\u000f\u0000\u0000FE\u0001\u0000\u0000\u0000"+
		"FG\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HL\u0005\u0016\u0000"+
		"\u0000IK\u0005\"\u0000\u0000JI\u0001\u0000\u0000\u0000KN\u0001\u0000\u0000"+
		"\u0000LM\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000MP\u0001\u0000"+
		"\u0000\u0000NL\u0001\u0000\u0000\u0000OQ\u0005\b\u0000\u0000PO\u0001\u0000"+
		"\u0000\u0000PQ\u0001\u0000\u0000\u0000Q\u0005\u0001\u0000\u0000\u0000"+
		"RV\u0005\"\u0000\u0000SU\u0003\b\u0004\u0000TS\u0001\u0000\u0000\u0000"+
		"UX\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000"+
		"\u0000W\u0007\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000YZ\u0007"+
		"\u0000\u0000\u0000Z\t\u0001\u0000\u0000\u0000[^\u0003\f\u0006\u0000\\"+
		"^\u0003$\u0012\u0000][\u0001\u0000\u0000\u0000]\\\u0001\u0000\u0000\u0000"+
		"^\u000b\u0001\u0000\u0000\u0000_a\u0003\u000e\u0007\u0000`b\u0005\"\u0000"+
		"\u0000a`\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bd\u0001\u0000"+
		"\u0000\u0000ce\u0005\t\u0000\u0000dc\u0001\u0000\u0000\u0000de\u0001\u0000"+
		"\u0000\u0000eg\u0001\u0000\u0000\u0000fh\u0005\"\u0000\u0000gf\u0001\u0000"+
		"\u0000\u0000gh\u0001\u0000\u0000\u0000hj\u0001\u0000\u0000\u0000ik\u0005"+
		"\"\u0000\u0000ji\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000km\u0001"+
		"\u0000\u0000\u0000ln\u0005\t\u0000\u0000ml\u0001\u0000\u0000\u0000mn\u0001"+
		"\u0000\u0000\u0000np\u0001\u0000\u0000\u0000oq\u0005\"\u0000\u0000po\u0001"+
		"\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qs\u0001\u0000\u0000\u0000"+
		"rt\u0005\"\u0000\u0000sr\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000uy\u0005\u0001\u0000\u0000vx\u0003\u001c\u000e"+
		"\u0000wv\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001\u0000"+
		"\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000|}\u0005\u0002\u0000\u0000}\r\u0001\u0000\u0000\u0000"+
		"~\u0084\u0003\u0010\b\u0000\u007f\u0080\u0003\u001a\r\u0000\u0080\u0081"+
		"\u0003\u0010\b\u0000\u0081\u0083\u0001\u0000\u0000\u0000\u0082\u007f\u0001"+
		"\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0089\u0001"+
		"\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u0088\u0005"+
		"\t\u0000\u0000\u0088\u008a\u0003\u000e\u0007\u0000\u0089\u0087\u0001\u0000"+
		"\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u000f\u0001\u0000"+
		"\u0000\u0000\u008b\u008e\u0003\u0012\t\u0000\u008c\u008e\u0003\u0014\n"+
		"\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008c\u0001\u0000\u0000"+
		"\u0000\u008e\u0094\u0001\u0000\u0000\u0000\u008f\u0093\u0005\u0017\u0000"+
		"\u0000\u0090\u0093\u0003\u0016\u000b\u0000\u0091\u0093\u0003\u0018\f\u0000"+
		"\u0092\u008f\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000"+
		"\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0096\u0001\u0000\u0000\u0000"+
		"\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000"+
		"\u0095\u0011\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000"+
		"\u0097\u0099\u0005\"\u0000\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0001\u0000\u0000\u0000\u0099\u0013\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0005\u000e\u0000\u0000\u009b\u0015\u0001\u0000\u0000\u0000\u009c"+
		"\u009d\u0005\n\u0000\u0000\u009d\u009e\u0005\"\u0000\u0000\u009e\u0017"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u0005\u0000\u0000\u00a0\u00a1"+
		"\u0005\"\u0000\u0000\u00a1\u00a2\u0007\u0001\u0000\u0000\u00a2\u00a3\u0005"+
		"\"\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a9\u0005\u0006"+
		"\u0000\u0000\u00a5\u00a6\u0005\u0005\u0000\u0000\u00a6\u00a7\u0005\"\u0000"+
		"\u0000\u00a7\u00a9\u0005\u0006\u0000\u0000\u00a8\u009f\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a5\u0001\u0000\u0000\u0000\u00a9\u0019\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ae\u0005\u0016\u0000\u0000\u00ab\u00ae\u0005\f\u0000\u0000"+
		"\u00ac\u00ae\u0005\u0018\u0000\u0000\u00ad\u00aa\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ae\u001b\u0001\u0000\u0000\u0000\u00af\u00b0\u0003\u001e\u000f\u0000"+
		"\u00b0\u00b1\u0005\b\u0000\u0000\u00b1\u00b3\u0003 \u0010\u0000\u00b2"+
		"\u00b4\u0005\u0007\u0000\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b4\u001d\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b8\u0005\"\u0000\u0000\u00b6\u00b8\u0005!\u0000\u0000\u00b7\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b8\u001f"+
		"\u0001\u0000\u0000\u0000\u00b9\u00bb\u0003\"\u0011\u0000\u00ba\u00b9\u0001"+
		"\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd!\u0001\u0000"+
		"\u0000\u0000\u00be\u00dc\u0005\"\u0000\u0000\u00bf\u00dc\u0005!\u0000"+
		"\u0000\u00c0\u00dc\u0005 \u0000\u0000\u00c1\u00dc\u0005\u0017\u0000\u0000"+
		"\u00c2\u00dc\u0005(\u0000\u0000\u00c3\u00c7\u0005)\u0000\u0000\u00c4\u00c6"+
		"\u0007\u0002\u0000\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c9"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c8\u00ca\u0001\u0000\u0000\u0000\u00c9\u00c7"+
		"\u0001\u0000\u0000\u0000\u00ca\u00dc\u0005\u0004\u0000\u0000\u00cb\u00cc"+
		"\u0005\u0003\u0000\u0000\u00cc\u00cd\u0003 \u0010\u0000\u00cd\u00ce\u0005"+
		"\u0004\u0000\u0000\u00ce\u00dc\u0001\u0000\u0000\u0000\u00cf\u00dc\u0005"+
		"\t\u0000\u0000\u00d0\u00dc\u0005\n\u0000\u0000\u00d1\u00dc\u0005\b\u0000"+
		"\u0000\u00d2\u00dc\u0005\u000f\u0000\u0000\u00d3\u00dc\u0005\u0015\u0000"+
		"\u0000\u00d4\u00dc\u0005\f\u0000\u0000\u00d5\u00dc\u0005\r\u0000\u0000"+
		"\u00d6\u00dc\u0005\u000e\u0000\u0000\u00d7\u00dc\u0005\u0018\u0000\u0000"+
		"\u00d8\u00dc\u0005\u000b\u0000\u0000\u00d9\u00dc\u0005\u0012\u0000\u0000"+
		"\u00da\u00dc\u0005%\u0000\u0000\u00db\u00be\u0001\u0000\u0000\u0000\u00db"+
		"\u00bf\u0001\u0000\u0000\u0000\u00db\u00c0\u0001\u0000\u0000\u0000\u00db"+
		"\u00c1\u0001\u0000\u0000\u0000\u00db\u00c2\u0001\u0000\u0000\u0000\u00db"+
		"\u00c3\u0001\u0000\u0000\u0000\u00db\u00cb\u0001\u0000\u0000\u0000\u00db"+
		"\u00cf\u0001\u0000\u0000\u0000\u00db\u00d0\u0001\u0000\u0000\u0000\u00db"+
		"\u00d1\u0001\u0000\u0000\u0000\u00db\u00d2\u0001\u0000\u0000\u0000\u00db"+
		"\u00d3\u0001\u0000\u0000\u0000\u00db\u00d4\u0001\u0000\u0000\u0000\u00db"+
		"\u00d5\u0001\u0000\u0000\u0000\u00db\u00d6\u0001\u0000\u0000\u0000\u00db"+
		"\u00d7\u0001\u0000\u0000\u0000\u00db\u00d8\u0001\u0000\u0000\u0000\u00db"+
		"\u00d9\u0001\u0000\u0000\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00dc"+
		"#\u0001\u0000\u0000\u0000\u00dd\u00e6\u0005*\u0000\u0000\u00de\u00e5\u0003"+
		"\"\u0011\u0000\u00df\u00e1\u0005)\u0000\u0000\u00e0\u00e2\u0007\u0003"+
		"\u0000\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e5\u0005\u0004"+
		"\u0000\u0000\u00e4\u00de\u0001\u0000\u0000\u0000\u00e4\u00df\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e8\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e9\u0001\u0000"+
		"\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e9\u00ea\u0003&\u0013"+
		"\u0000\u00ea%\u0001\u0000\u0000\u0000\u00eb\u00f1\u0005\u0001\u0000\u0000"+
		"\u00ec\u00f0\u0003\f\u0006\u0000\u00ed\u00f0\u0003\u001c\u000e\u0000\u00ee"+
		"\u00f0\u0003$\u0012\u0000\u00ef\u00ec\u0001\u0000\u0000\u0000\u00ef\u00ed"+
		"\u0001\u0000\u0000\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00f0\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f4\u0001\u0000\u0000\u0000\u00f3\u00f1"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f7\u0005\u0002\u0000\u0000\u00f5\u00f7"+
		"\u0005\u0007\u0000\u0000\u00f6\u00eb\u0001\u0000\u0000\u0000\u00f6\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f7\'\u0001\u0000\u0000\u0000\u00f8\u00f9\u0003"+
		"*\u0015\u0000\u00f9)\u0001\u0000\u0000\u0000\u00fa\u00fd\u0003,\u0016"+
		"\u0000\u00fb\u00fd\u0003.\u0017\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fd+\u0001\u0000\u0000\u0000\u00fe"+
		"\u0102\u0005.\u0000\u0000\u00ff\u0101\u0005\"\u0000\u0000\u0100\u00ff"+
		"\u0001\u0000\u0000\u0000\u0101\u0104\u0001\u0000\u0000\u0000\u0102\u0103"+
		"\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0103\u0105"+
		"\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105\u0106"+
		"\u0005/\u0000\u0000\u0106-\u0001\u0000\u0000\u0000\u0107\u010b\u0005,"+
		"\u0000\u0000\u0108\u010a\u00030\u0018\u0000\u0109\u0108\u0001\u0000\u0000"+
		"\u0000\u010a\u010d\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000"+
		"\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010e\u0001\u0000\u0000"+
		"\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010e\u010f\u0005-\u0000\u0000"+
		"\u010f/\u0001\u0000\u0000\u0000\u0110\u0111\u0007\u0004\u0000\u0000\u0111"+
		"1\u0001\u0000\u0000\u0000\'57>BFLPV]adgjmpsy\u0084\u0089\u008d\u0092\u0094"+
		"\u0098\u00a8\u00ad\u00b3\u00b7\u00bc\u00c7\u00db\u00e1\u00e4\u00e6\u00ef"+
		"\u00f1\u00f6\u00fc\u0102\u010b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}