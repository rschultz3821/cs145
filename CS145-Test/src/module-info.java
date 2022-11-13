module uwstout.cs145 {
	requires transitive javafx.graphics;
	requires junit;
	requires javafx.controls;
	requires javafx.base;
	requires org.testfx.junit;
	requires org.testfx;

	exports uwstout.cs145.GUITesting;
	exports uwstout.cs145.GUITesting.ClassExamples;
}