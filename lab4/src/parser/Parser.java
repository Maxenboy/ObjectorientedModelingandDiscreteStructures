package parser;

import java.io.Reader;
import java.io.StringReader;
import Satslogik.*;

public class Parser {
	private Scanner scanner;
	private int token;

	public Expr build(Reader reader) {
		scanner = new Scanner(reader);
		token = scanner.nextToken();
		Expr expr = expr();
		if (token == Scanner.EOF) {
			return expr;
		} else {
			throw new ParserException("Trailing garbage after "
					+ scanner.token());
		}
	}

	public Expr build(String input) {
		return build(new StringReader(input));
	}

	private Expr expr() {
		Expr result, primary;
		result = primary();
		if (token == Scanner.IMPLIES) {
			token = scanner.nextToken();
			primary = primary();
			return new Implication(result, primary);
		}
		return result;
	}

	private Expr primary() {
		Expr result, term;
		result = term();
		while (token == '|') {
			token = scanner.nextToken();
			term = term();
			result = new Disjunction(result, term);
		}
		return result;
	}

	private Expr term() {
		Expr result, factor;
		result = factor();
		while (token == '&') {
			token = scanner.nextToken();
			factor = factor();
			result = new Conjunction(result, factor);
		}
		return result;
	}

	private Expr factor() {
		switch (token) {
		case Scanner.VARIABLE:
			String name = scanner.token();
			token = scanner.nextToken();
			return new Variable(name);
		case '!':
			token = scanner.nextToken();
			Expr neg = new Negate(factor());
			token = scanner.nextToken();
			return neg;
		case '(':
			token = scanner.nextToken();
			Expr expr = expr();
			if(!scanner.token().equals(")")){
				throw new ParserException("Expecting \")\", found: " + scanner.token());
			}
			token = scanner.nextToken();
			return expr;
			
		default:
			throw new ParserException("Unexpected " + scanner.token());
		}
	}

}