package com.example.appcontarestauranteanima;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etConta;
    Button btCalcular;
TextView tvResultado;
    TextView tvGorjeta;
    TextView tv_agradecimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vínculo entre java e XML
        etConta = findViewById(R.id.et_conta);
        btCalcular = findViewById(R.id.bt_calcular);
        tvResultado = findViewById(R.id.tv_resultado);
        tvGorjeta = findViewById(R.id.tv_gorjeta_garcom);
tv_agradecimento = findViewById(R.id.tv_agradecimento);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double conta = Double.parseDouble(etConta.getText().toString());
                double gorjeta = conta * 0.10;
                conta = conta * 1.10;
                tvGorjeta.setText(String.format("R$ %.2f", gorjeta));
                tvResultado.setText(String.format("R$ %.2f", conta));
                tv_agradecimento.setText(String.format("Obrigado pela preferência!"));
            }
        });

    }// fim do onCreate
}