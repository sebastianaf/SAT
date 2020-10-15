// Generated from C:/Users/57310/Documents/Github/SAT/src/reduction/Antlr\SatParser.g4 by ANTLR 4.8
package reduction.Antlr;

    import java.lang.Math;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SatParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, COMMENT_BREAK=2, WS_COMMENT=3, P=4, CNF=5, NUMBER=6, ZERO=7, 
		BREAK=8, WS=9;
	public static final int
		RULE_document = 0, RULE_commentary = 1, RULE_header = 2, RULE_clause = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "commentary", "header", "clause"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'p'", "'cnf'", null, "'0'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "COMMENT_BREAK", "WS_COMMENT", "P", "CNF", "NUMBER", 
			"ZERO", "BREAK", "WS"
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
	public String getGrammarFileName() { return "SatParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	    private int xsat;
	    private int numNewVariables=0;
	    private int numNewClauses=0;

	    public SatParser(TokenStream input, int xsatIn){
	        this(input);
	        this.xsat = xsatIn;
	    }

	    public int getNewVariables(){
	        return this.numNewVariables;
	    }
	    public int getNewClauses(){
	        return this.numNewClauses;
	    }

	public SatParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class DocumentContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<TerminalNode> COMMENT_BREAK() { return getTokens(SatParser.COMMENT_BREAK); }
		public TerminalNode COMMENT_BREAK(int i) {
			return getToken(SatParser.COMMENT_BREAK, i);
		}
		public List<CommentaryContext> commentary() {
			return getRuleContexts(CommentaryContext.class);
		}
		public CommentaryContext commentary(int i) {
			return getRuleContext(CommentaryContext.class,i);
		}
		public List<ClauseContext> clause() {
			return getRuleContexts(ClauseContext.class);
		}
		public ClauseContext clause(int i) {
			return getRuleContext(ClauseContext.class,i);
		}
		public List<TerminalNode> BREAK() { return getTokens(SatParser.BREAK); }
		public TerminalNode BREAK(int i) {
			return getToken(SatParser.BREAK, i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SatParserListener ) ((SatParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SatParserListener ) ((SatParserListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SatParserVisitor ) return ((SatParserVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT_BREAK) {
				{
				{
				setState(8);
				match(COMMENT_BREAK);
				}
				}
				setState(13);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(14);
				commentary();
				}
				}
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(20);
			header();
			setState(22); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(21);
					clause();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(24); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BREAK) {
				{
				{
				setState(26);
				match(BREAK);
				}
				}
				setState(31);
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

	public static class CommentaryContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(SatParser.COMMENT, 0); }
		public List<TerminalNode> COMMENT_BREAK() { return getTokens(SatParser.COMMENT_BREAK); }
		public TerminalNode COMMENT_BREAK(int i) {
			return getToken(SatParser.COMMENT_BREAK, i);
		}
		public CommentaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commentary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SatParserListener ) ((SatParserListener)listener).enterCommentary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SatParserListener ) ((SatParserListener)listener).exitCommentary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SatParserVisitor ) return ((SatParserVisitor<? extends T>)visitor).visitCommentary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentaryContext commentary() throws RecognitionException {
		CommentaryContext _localctx = new CommentaryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_commentary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(COMMENT);
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				match(COMMENT_BREAK);
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMENT_BREAK );
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

	public static class HeaderContext extends ParserRuleContext {
		public TerminalNode P() { return getToken(SatParser.P, 0); }
		public TerminalNode CNF() { return getToken(SatParser.CNF, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(SatParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SatParser.NUMBER, i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SatParserListener ) ((SatParserListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SatParserListener ) ((SatParserListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SatParserVisitor ) return ((SatParserVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(P);
			setState(39);
			match(CNF);
			setState(40);
			match(NUMBER);
			setState(41);
			match(NUMBER);
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

	public static class ClauseContext extends ParserRuleContext {
		public int i = 0;
		public List<TerminalNode> BREAK() { return getTokens(SatParser.BREAK); }
		public TerminalNode BREAK(int i) {
			return getToken(SatParser.BREAK, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(SatParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(SatParser.NUMBER, i);
		}
		public TerminalNode ZERO() { return getToken(SatParser.ZERO, 0); }
		public ClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SatParserListener ) ((SatParserListener)listener).enterClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SatParserListener ) ((SatParserListener)listener).exitClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SatParserVisitor ) return ((SatParserVisitor<? extends T>)visitor).visitClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClauseContext clause() throws RecognitionException {
		ClauseContext _localctx = new ClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(44); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(43);
				match(BREAK);
				}
				}
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==BREAK );
			setState(50); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(48);
				match(NUMBER);

				                    _localctx.i++;
				                
				}
				}
				setState(52); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER );
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ZERO) {
				{
				setState(54);
				match(ZERO);
				}
			}

			}

			                    if(_localctx.i<this.xsat){
			                        this.numNewVariables = this.numNewVariables + this.xsat - _localctx.i;
			                        this.numNewClauses = this.numNewClauses + (int)Math.pow(2,this.xsat - _localctx.i);

			                    }
			                    else{
			                        this.numNewVariables = this.numNewVariables + _localctx.i - this.xsat;
			                        this.numNewClauses = this.numNewClauses + _localctx.i - this.xsat + 1;
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13>\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\7\2\f\n\2\f\2\16\2\17\13\2\3\2\7\2\22\n\2\f\2\16"+
		"\2\25\13\2\3\2\3\2\6\2\31\n\2\r\2\16\2\32\3\2\7\2\36\n\2\f\2\16\2!\13"+
		"\2\3\3\3\3\6\3%\n\3\r\3\16\3&\3\4\3\4\3\4\3\4\3\4\3\5\6\5/\n\5\r\5\16"+
		"\5\60\3\5\3\5\6\5\65\n\5\r\5\16\5\66\3\5\5\5:\n\5\3\5\3\5\3\5\2\2\6\2"+
		"\4\6\b\2\2\2A\2\r\3\2\2\2\4\"\3\2\2\2\6(\3\2\2\2\b.\3\2\2\2\n\f\7\4\2"+
		"\2\13\n\3\2\2\2\f\17\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\23\3\2\2\2\17"+
		"\r\3\2\2\2\20\22\5\4\3\2\21\20\3\2\2\2\22\25\3\2\2\2\23\21\3\2\2\2\23"+
		"\24\3\2\2\2\24\26\3\2\2\2\25\23\3\2\2\2\26\30\5\6\4\2\27\31\5\b\5\2\30"+
		"\27\3\2\2\2\31\32\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\37\3\2\2\2\34"+
		"\36\7\n\2\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \3\3\2"+
		"\2\2!\37\3\2\2\2\"$\7\3\2\2#%\7\4\2\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'"+
		"\3\2\2\2\'\5\3\2\2\2()\7\6\2\2)*\7\7\2\2*+\7\b\2\2+,\7\b\2\2,\7\3\2\2"+
		"\2-/\7\n\2\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\64\3\2"+
		"\2\2\62\63\7\b\2\2\63\65\b\5\1\2\64\62\3\2\2\2\65\66\3\2\2\2\66\64\3\2"+
		"\2\2\66\67\3\2\2\2\679\3\2\2\28:\7\t\2\298\3\2\2\29:\3\2\2\2:;\3\2\2\2"+
		";<\b\5\1\2<\t\3\2\2\2\n\r\23\32\37&\60\669";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}