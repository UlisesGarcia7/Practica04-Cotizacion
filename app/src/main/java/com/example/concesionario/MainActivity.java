package com.example.concesionario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtNumCotizacion;
    private EditText txtDescripcion;
    private EditText txtPrecio;
    private EditText txtPorcentajePagoInicial;
    private EditText txtPlazo;
    private Button btnReiniciar;
    private Button btnCalcular;
    private TextView lblMostrarRes;
    private Button btnCerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumCotizacion = (EditText) findViewById(R.id.txtNumCotizacion);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        txtPrecio = (EditText) findViewById(R.id.txtPrecio);
        txtPorcentajePagoInicial = (EditText) findViewById(R.id.txtPorcentajePagoInicial);
        txtPlazo = (EditText) findViewById(R.id.txtPlazo);
        btnReiniciar = (Button) findViewById(R.id.btnReiniciar);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        lblMostrarRes = (TextView) findViewById(R.id.lblMostrarRes);
        btnCerrar = (Button) findViewById(R.id.btnCerrar);

        Cotizacion Coti = new Cotizacion();

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNumCotizacion.getText().toString().matches("") && txtDescripcion.getText().toString().matches("") &&
                        txtPrecio.getText().toString().matches("") && txtPorcentajePagoInicial.getText().toString().matches("") &&
                        txtPlazo.getText().toString().matches("") && lblMostrarRes.getText().toString().matches("")){
                            Toast.makeText(MainActivity.this, "Todos Los Campos Se Encuentran Vacios",Toast.LENGTH_LONG).show();
                } else {
                    txtNumCotizacion.setText("");
                    txtDescripcion.setText("");
                    txtPrecio.setText("");
                    txtPorcentajePagoInicial.setText("");
                    txtPlazo.setText("");
                    lblMostrarRes.setText("");
                    Toast.makeText(MainActivity.this, "Campos Reiniciados",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNumCotizacion.getText().toString().matches("") || txtDescripcion.getText().toString().matches("") ||
                        txtPrecio.getText().toString().matches("") || txtPorcentajePagoInicial.getText().toString().matches("") ||
                        txtPlazo.getText().toString().matches("")){
                            Toast.makeText(MainActivity.this, "Falta Llenar Campos",Toast.LENGTH_LONG).show();
                } else {
                    int numCotizacion = Integer.parseInt(txtNumCotizacion.getText().toString());
                    Coti.setNumCotizacion(numCotizacion);
                    String descripcion = txtDescripcion.getText().toString();
                    Coti.setDescripcion(descripcion);
                    double precio = Double.parseDouble(txtPrecio.getText().toString());
                    Coti.setPrecio(precio);
                    double porcentajePagoInicial = Double.parseDouble(txtPorcentajePagoInicial.getText().toString());
                    Coti.setPorcentajePagoInicial(porcentajePagoInicial);
                    int plazo = Integer.parseInt(txtPlazo.getText().toString());
                    Coti.setPlazo(plazo);

                    lblMostrarRes.setText(" - - - - - - - - - - COTIZACION  A PAGAR - - - - - - - - -  " +
                                          "\n\n - - - - - INFORMACION BASICA - - - - -" +
                                          "\n\nNum. Cotizacion: " + Coti.getNumCotizacion() +
                                          "\nDescripcion: " + Coti.getDescripcion() +
                                          "\nPrecio: $" + Coti.getPrecio() +
                                          "\nPorcentaje Pago Inicial: " + Coti.getPorcentajePagoInicial() + "%" +
                                          "\nPlazo: " + Coti.getPlazo() + " Meses" +
                                          "\n\n - - - - - PAGO - - - - -" +
                                          "\n\nPago Inicial: $" + Coti.calcularPagoInicial() +
                                          "\nTotal a Fin: $" + Coti.calcularTotalFinanciero() +
                                          "\nPlazo Mensual: $ " + Coti.calcularPagoMensual());

                }
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}