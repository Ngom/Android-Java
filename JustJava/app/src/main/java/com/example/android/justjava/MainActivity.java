package com.example.android.justjava;


/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100){
            // show the error as Toast !!!
            Toast.makeText(this, "You can not have more than 100 coffees", Toast.LENGTH_SHORT).show();
            // exit execution !!!
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }


    /**
     * This method is called when the decrement button is clicked.
     */
    public void decrement(View view) {
        // You can not order 0 cup of coffee !
        if (quantity > 1) {
            quantity = quantity - 1;
        }else {
            // show the error as Toast !!!
            Toast.makeText(this, "You can not have less than 1 coffee", Toast.LENGTH_SHORT).show();
            display(quantity);
            return;
        }
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // figure out whipped cream checkbox
        CheckBox checkBox = (CheckBox) findViewById(R.id.mycheckbox);
        boolean hasWhippedCream = false;
        if (checkBox.isChecked()){
            hasWhippedCream = true;
        }
        // figure out chocolate checkbox
        CheckBox chocoCheckBox = (CheckBox) findViewById(R.id.secondcheckbox);
        boolean hasChocolate = false;
        hasChocolate = chocoCheckBox.isChecked();
        // figure out costumer's input name
        EditText textName = (EditText) findViewById(R.id.name_edit_text);
        String name = textName.getText().toString();
        // Log.v("MainActivity", "Name " + name);
        // Figure the basedPrice calculation !
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        // call createOrderSummary method
        String message = createOrderSummary(price, hasWhippedCream, hasChocolate, name);
        // Send the order as email
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, message); // To set the body of the email!
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * Define calculatePrice method here below !
     * @param addChocolate to set its price to $ 1
     * @param addWhippeCream to set its price to $ 2
     * @return Total price.
     */
    private int calculatePrice(boolean addWhippeCream, boolean addChocolate) {
        // coffee unit price
        int basedPrice = 5;
        // add whipped extra price
        if (addWhippeCream ){
            basedPrice += 1;
        }
        // add chocolate extra price
        if (addChocolate){
            basedPrice += 2;
        }
        // calculte the total price
        return quantity * basedPrice;
    }

    /**
     * CreateOrderSummary method defined here!
     * @param name of costumer
     * @param hasChocolate as boolean
     * @param hasWhippedCream as boolean
     * @return  the summary of oder.
     * @param price of total order,
     */
    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String name) {
        String message = "Name: " + name;
        message += "\nWhipped Cream: " + hasWhippedCream;
        message += "\nChocolate: " + hasChocolate;
        message += "\nQuantity: " + quantity;
        message += "\nTotal: $" + price;
        message += "\nThank you!";
        return message;
    }
}