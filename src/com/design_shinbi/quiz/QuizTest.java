package com.design_shinbi.quiz;

import org.junit.jupiter.api.Test;

class QuizTest {

	@Test
	void test() {
		String line = "ドラえもんの誕生日は？,９月３日,８月２日,７月１日,１０月４日";

		Question question = new Question();
		question.readLine(line);
		question.display();
	}

}
