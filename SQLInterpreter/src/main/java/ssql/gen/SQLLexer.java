package ssql.gen;

// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, SELECT=5, FROM=6, WHERE=7, AND=8, OR=9, 
		NOT=10, TRUE=11, FALSE=12, WS=13, INTEGER=14, IDENTIFIER=15, STRING=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "SELECT", "FROM", "WHERE", "AND", "OR", 
			"NOT", "TRUE", "FALSE", "WS", "INTEGER", "IDENTIFIER", "STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'='", "'('", "')'", "'select'", "'from'", "'where'", "'and'", 
			"'or'", "'not'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "SELECT", "FROM", "WHERE", "AND", "OR", 
			"NOT", "TRUE", "FALSE", "WS", "INTEGER", "IDENTIFIER", "STRING"
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


	public SQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0010m\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0004\fS\b\f\u000b"+
		"\f\f\fT\u0001\f\u0001\f\u0001\r\u0004\rZ\b\r\u000b\r\f\r[\u0001\u000e"+
		"\u0001\u000e\u0005\u000e`\b\u000e\n\u000e\f\u000ec\t\u000e\u0001\u000f"+
		"\u0001\u000f\u0005\u000fg\b\u000f\n\u000f\f\u000fj\t\u000f\u0001\u000f"+
		"\u0001\u000f\u0000\u0000\u0010\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010\u0001\u0000\u0004"+
		"\u0003\u0000\t\n\r\r  \u0001\u000009\u0003\u0000AZ__az\u0004\u000009A"+
		"Z__azp\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0001"+
		"!\u0001\u0000\u0000\u0000\u0003#\u0001\u0000\u0000\u0000\u0005%\u0001"+
		"\u0000\u0000\u0000\u0007\'\u0001\u0000\u0000\u0000\t)\u0001\u0000\u0000"+
		"\u0000\u000b0\u0001\u0000\u0000\u0000\r5\u0001\u0000\u0000\u0000\u000f"+
		";\u0001\u0000\u0000\u0000\u0011?\u0001\u0000\u0000\u0000\u0013B\u0001"+
		"\u0000\u0000\u0000\u0015F\u0001\u0000\u0000\u0000\u0017K\u0001\u0000\u0000"+
		"\u0000\u0019R\u0001\u0000\u0000\u0000\u001bY\u0001\u0000\u0000\u0000\u001d"+
		"]\u0001\u0000\u0000\u0000\u001fd\u0001\u0000\u0000\u0000!\"\u0005,\u0000"+
		"\u0000\"\u0002\u0001\u0000\u0000\u0000#$\u0005=\u0000\u0000$\u0004\u0001"+
		"\u0000\u0000\u0000%&\u0005(\u0000\u0000&\u0006\u0001\u0000\u0000\u0000"+
		"\'(\u0005)\u0000\u0000(\b\u0001\u0000\u0000\u0000)*\u0005s\u0000\u0000"+
		"*+\u0005e\u0000\u0000+,\u0005l\u0000\u0000,-\u0005e\u0000\u0000-.\u0005"+
		"c\u0000\u0000./\u0005t\u0000\u0000/\n\u0001\u0000\u0000\u000001\u0005"+
		"f\u0000\u000012\u0005r\u0000\u000023\u0005o\u0000\u000034\u0005m\u0000"+
		"\u00004\f\u0001\u0000\u0000\u000056\u0005w\u0000\u000067\u0005h\u0000"+
		"\u000078\u0005e\u0000\u000089\u0005r\u0000\u00009:\u0005e\u0000\u0000"+
		":\u000e\u0001\u0000\u0000\u0000;<\u0005a\u0000\u0000<=\u0005n\u0000\u0000"+
		"=>\u0005d\u0000\u0000>\u0010\u0001\u0000\u0000\u0000?@\u0005o\u0000\u0000"+
		"@A\u0005r\u0000\u0000A\u0012\u0001\u0000\u0000\u0000BC\u0005n\u0000\u0000"+
		"CD\u0005o\u0000\u0000DE\u0005t\u0000\u0000E\u0014\u0001\u0000\u0000\u0000"+
		"FG\u0005t\u0000\u0000GH\u0005r\u0000\u0000HI\u0005u\u0000\u0000IJ\u0005"+
		"e\u0000\u0000J\u0016\u0001\u0000\u0000\u0000KL\u0005f\u0000\u0000LM\u0005"+
		"a\u0000\u0000MN\u0005l\u0000\u0000NO\u0005s\u0000\u0000OP\u0005e\u0000"+
		"\u0000P\u0018\u0001\u0000\u0000\u0000QS\u0007\u0000\u0000\u0000RQ\u0001"+
		"\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000"+
		"TU\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0006\f\u0000\u0000"+
		"W\u001a\u0001\u0000\u0000\u0000XZ\u0007\u0001\u0000\u0000YX\u0001\u0000"+
		"\u0000\u0000Z[\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001"+
		"\u0000\u0000\u0000\\\u001c\u0001\u0000\u0000\u0000]a\u0007\u0002\u0000"+
		"\u0000^`\u0007\u0003\u0000\u0000_^\u0001\u0000\u0000\u0000`c\u0001\u0000"+
		"\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b\u001e"+
		"\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000dh\u0005\"\u0000\u0000"+
		"eg\u0007\u0003\u0000\u0000fe\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000"+
		"\u0000\u0000jh\u0001\u0000\u0000\u0000kl\u0005\"\u0000\u0000l \u0001\u0000"+
		"\u0000\u0000\u0005\u0000T[ah\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}