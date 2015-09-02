package analise.credito.view.components;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class CurrencyTextField extends TextField {
	
	private static final String CURRENCY_CONSTANT = "$1.$2";
	
	public CurrencyTextField() {
		configureMask();
	}

	private void configureMask() {
		lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String value = getText();
                value = "R$ " + value.replaceAll("[^0-9]", "");
                value = value.replaceAll("([0-9]{1})([0-9]{14})$", CURRENCY_CONSTANT);
                value = value.replaceAll("([0-9]{1})([0-9]{11})$", CURRENCY_CONSTANT);
                value = value.replaceAll("([0-9]{1})([0-9]{8})$", CURRENCY_CONSTANT);
                value = value.replaceAll("([0-9]{1})([0-9]{5})$", CURRENCY_CONSTANT);
                value = value.replaceAll("([0-9]{1})([0-9]{2})$", CURRENCY_CONSTANT);
                setText(value);
                positionCaret();

                textProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                        if (newValue.length() > 17)
                        	setText(oldValue);
                    }
                });
            }
        });
	}
	
	private void positionCaret() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
            	CurrencyTextField.this.positionCaret(CurrencyTextField.this.getText().length());
            }
        });
    }
	
}
