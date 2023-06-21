package silva.evangelista.santos.wilsiman.galeria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Abaixo é obtido o elemento tbMain
        Toolbar toolbar = findViewById(R.id.tbMain);
        //Abaixo indica para MainActivity que tbMain deve ser considerado como a ActionBar padrão da tela
        setSupportActionBar(toolbar);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        super.onCreateOptionsMenu(menu);
        //Abaixo é criado um inflador de menu
        MenuInflater inflater = getMenuInflater();
        // Abaixo o inflador cria as opções de menu definifas no arquivo main_activity_tb.xml e as adiciona no menu Activity
        inflater.inflate(R.menu.main_activity_tb, menu);
        return true;
    }

    //O método abaixo será chamado sempre que um item da ToolBar for selecionado
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()) {
            case R.id.opCamera:
                //Abaixo determina que caso o ícone de câmera tenha sido clicado, então será executado código que dispara a câmera do celular
                dispatchTakePictureIntent();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void dispatchTakePictureIntent() {
    }
}