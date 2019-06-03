package uroborosGameStudio.ui.components;

import java.awt.Insets;

import org.fife.rsta.ac.LanguageSupportFactory;
import org.fife.rsta.ac.js.JavaScriptLanguageSupport;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;


@SuppressWarnings("serial")
public class JavaScriptEditor extends RTextScrollPane 
{
	public JavaScriptEditor() 
	{
		super(new JavaScriptEditorTextArea());
	}

	public static class JavaScriptEditorTextArea extends RSyntaxTextArea 
	{
		private final JavaScriptLanguageSupport js;

		public JavaScriptEditorTextArea() {
			super();
			this.js = (JavaScriptLanguageSupport) LanguageSupportFactory.get().getSupportFor(SYNTAX_STYLE_JAVASCRIPT);
			this.js.setStrictMode(true);
			this.js.install(this);
			this.setSyntaxEditingStyle(SYNTAX_STYLE_JAVASCRIPT);
			this.setCodeFoldingEnabled(true);
			this.setAntiAliasingEnabled(true);
			this.setMargin(new Insets(10, 10, 10, 0));
			this.setAutoIndentEnabled(true);
			this.setAutoscrolls(true);
			this.setFractionalFontMetricsEnabled(true);
		}
	}

	@Override
	public void grabFocus() {
		this.getTextArea().grabFocus();
	}
	
	public JavaScriptEditorTextArea getJSTextArea() {
		return (JavaScriptEditorTextArea) this.getTextArea();
	}

	public String getText() {
		return this.getJSTextArea().getText();
	}

	public void setText(String text) {
		this.getJSTextArea().setText(text);
	}
}