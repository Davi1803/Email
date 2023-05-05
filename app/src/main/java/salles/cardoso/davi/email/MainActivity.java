package salles.cardoso.davi.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    //criando método onCreate
    protected void onCreate(Bundle savedInstanceState) {
        //Chamando superclasse do método
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //criando botão de enviar
        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);
        //Definição da ação do click do botão
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtendo dadods digitados pelo usuário
                EditText etEmail = (EditText) findViewById(R.id.etEmail);
                //declarando a String email e atribuindo o texto do editText à ela
                String email = etEmail.getText().toString();

                //Obtendo dados digitados pelo usuário
                EditText etAssunto = (EditText) findViewById(R.id.etAssunto);
                //declarando a String assunto e atribuindo o valor do editText à ela
                String assunto = etAssunto.getText().toString();

                //Obtendo dados digitados pelo usuário
                EditText etTexto = (EditText) findViewById(R.id.etTexto);
                //declarando a string texto e atribuindo o valor do editText à ela
                String texto = etTexto.getText().toString();

                //criando uma intenção de envio navegando para a tela em questão
                Intent i = new Intent(Intent.ACTION_SENDTO);

                //especificando a utilização de apps de email
                i.setData(Uri.parse("mailto:"));

                //criando um array de email
                String[] emails = new String[] {email};

                //inserindo os textos digitados pelo usuário na app de email
                i.putExtra(Intent.EXTRA_EMAIL, emails);
                i.putExtra(Intent.EXTRA_SUBJECT, assunto);
                i.putExtra(Intent.EXTRA_TEXT, texto);

                try{
                    //se tivesse mais um app de email, createChooser ("criar escolhedor")
                    startActivity(Intent.createChooser(i, "Escolha o APP"));
            }
                //verificando outras opções de app
                catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Não há nenhum que posso realizar essa operação", Toast.LENGTH_LONG).show();

                }
        };
        });
    }
}