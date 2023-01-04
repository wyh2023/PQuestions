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
		T__0=1, T__1=2, SELECT=3, FROM=4, WHERE=5, AND=6, OR=7, NOT=8, TRUE=9, 
		FALSE=10, WS=11, INTEGER=12, IDENTIFIER=13, STRING=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "SELECT", "FROM", "WHERE", "AND", "OR", "NOT", "TRUE", 
			"FALSE", "WS", "INTEGER", "IDENTIFIER", "STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'='", "'select'", "'from'", "'where'", "'and'", "'or'", 
			"'not'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "SELECT", "FROM", "WHERE", "AND", "OR", "NOT", "TRUE", 
			"FALSE", "WS", "INTEGER", "IDENTIFIER", "STRING"
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
		"\u0004\u0000\u000ee\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\n\u0004\nK\b\n\u000b\n\f\nL\u0001\n\u0001"+
		"\n\u0001\u000b\u0004\u000bR\b\u000b\u000b\u000b\f\u000bS\u0001\f\u0001"+
		"\f\u0005\fX\b\f\n\f\f\f[\t\f\u0001\r\u0001\r\u0005\r_\b\r\n\r\f\rb\t\r"+
		"\u0001\r\u0001\r\u0000\u0000\u000e\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u0001\u0000\u0004\u0003\u0000\t\n\r"+
		"\r  \u0001\u000009\u0003\u0000AZ__az\u0004\u000009AZ__azh\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0001\u001d\u0001\u0000"+
		"\u0000\u0000\u0003\u001f\u0001\u0000\u0000\u0000\u0005!\u0001\u0000\u0000"+
		"\u0000\u0007(\u0001\u0000\u0000\u0000\t-\u0001\u0000\u0000\u0000\u000b"+
		"3\u0001\u0000\u0000\u0000\r7\u0001\u0000\u0000\u0000\u000f:\u0001\u0000"+
		"\u0000\u0000\u0011>\u0001\u0000\u0000\u0000\u0013C\u0001\u0000\u0000\u0000"+
		"\u0015J\u0001\u0000\u0000\u0000\u0017Q\u0001\u0000\u0000\u0000\u0019U"+
		"\u0001\u0000\u0000\u0000\u001b\\\u0001\u0000\u0000\u0000\u001d\u001e\u0005"+
		",\u0000\u0000\u001e\u0002\u0001\u0000\u0000\u0000\u001f \u0005=\u0000"+
		"\u0000 \u0004\u0001\u0000\u0000\u0000!\"\u0005s\u0000\u0000\"#\u0005e"+
		"\u0000\u0000#$\u0005l\u0000\u0000$%\u0005e\u0000\u0000%&\u0005c\u0000"+
		"\u0000&\'\u0005t\u0000\u0000\'\u0006\u0001\u0000\u0000\u0000()\u0005f"+
		"\u0000\u0000)*\u0005r\u0000\u0000*+\u0005o\u0000\u0000+,\u0005m\u0000"+
		"\u0000,\b\u0001\u0000\u0000\u0000-.\u0005w\u0000\u0000./\u0005h\u0000"+
		"\u0000/0\u0005e\u0000\u000001\u0005r\u0000\u000012\u0005e\u0000\u0000"+
		"2\n\u0001\u0000\u0000\u000034\u0005a\u0000\u000045\u0005n\u0000\u0000"+
		"56\u0005d\u0000\u00006\f\u0001\u0000\u0000\u000078\u0005o\u0000\u0000"+
		"89\u0005r\u0000\u00009\u000e\u0001\u0000\u0000\u0000:;\u0005n\u0000\u0000"+
		";<\u0005o\u0000\u0000<=\u0005t\u0000\u0000=\u0010\u0001\u0000\u0000\u0000"+
		">?\u0005t\u0000\u0000?@\u0005r\u0000\u0000@A\u0005u\u0000\u0000AB\u0005"+
		"e\u0000\u0000B\u0012\u0001\u0000\u0000\u0000CD\u0005f\u0000\u0000DE\u0005"+
		"a\u0000\u0000EF\u0005l\u0000\u0000FG\u0005s\u0000\u0000GH\u0005e\u0000"+
		"\u0000H\u0014\u0001\u0000\u0000\u0000IK\u0007\u0000\u0000\u0000JI\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0006\n\u0000\u0000"+
		"O\u0016\u0001\u0000\u0000\u0000PR\u0007\u0001\u0000\u0000QP\u0001\u0000"+
		"\u0000\u0000RS\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001"+
		"\u0000\u0000\u0000T\u0018\u0001\u0000\u0000\u0000UY\u0007\u0002\u0000"+
		"\u0000VX\u0007\u0003\u0000\u0000WV\u0001\u0000\u0000\u0000X[\u0001\u0000"+
		"\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\u001a"+
		"\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000\\`\u0005\"\u0000\u0000"+
		"]_\u0007\u0003\u0000\u0000^]\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000"+
		"\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0001\u0000"+
		"\u0000\u0000b`\u0001\u0000\u0000\u0000cd\u0005\"\u0000\u0000d\u001c\u0001"+
		"\u0000\u0000\u0000\u0005\u0000LSY`\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}