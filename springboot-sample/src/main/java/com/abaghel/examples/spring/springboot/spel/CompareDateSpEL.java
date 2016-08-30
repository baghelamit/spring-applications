package com.abaghel.examples.spring.springboot.spel;

import java.time.ZonedDateTime;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Spring SpEL to compare Java 8 date
 * 
 * @author abaghel
 *
 */
public class CompareDateSpEL {
	
	public int compareDate(ZonedDateTime date1,ZonedDateTime date2) throws Exception {
		//SpEL Context
		EvaluationContext context = new StandardEvaluationContext(new ZonedDateTimeUtil());
	    context.setVariable("dateOne", date1);
	    context.setVariable("dateTwo", date2);
	    //SpEL Parser
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("compareDate(#dateOne, #dateTwo)");
		int value = (Integer) exp.getValue(context);
		return value;
	}

}

class ZonedDateTimeUtil {
	public int compareDate(ZonedDateTime dateOne, ZonedDateTime dateTwo){
		return dateOne.compareTo(dateTwo);
	}
}

