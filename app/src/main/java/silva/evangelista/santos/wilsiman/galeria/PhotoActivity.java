package silva.evangelista.santos.wilsiman.galeria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toolbar;

import java.io.File;

public class PhotoActivity extends AppCompatActivity {

    String photoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        //Abaixo é obtido o elemento tbPhoto
        Toolbar toolbar = findViewById(R.id.tbPhoto);
        //Abaixo indica para PhotoActivity que tbPhoto deve ser considerado como a ActionBar padrão da tela
        setSupportActionBar(toolbar);

        //Abaixo obtem-se da Activity a ActionBar padrão (a qual foi setada pelas linhas acima)
        ActionBar actionBar = getSupportActionBar();
        //Abaixo é habilitado o botão de voltar na ActionBar
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        photoPath = i.getStringExtra("photo_path");

        Bitmap bitmap = Utils.getBitmap(photoPath);
        ImageView imPhoto = findViewById(R.id.imPhoto);
        imPhoto.setImageBitmap(bitmap);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        super.onCreateOptionsMenu(menu);
        //Abaixo é criado um inflador de menu
        MenuInflater inflater = getMenuInflater();
        // Abaixo o inflador cria as opções de menu definifas no arquivo photo_activity_tb.xml e as adiciona no menu Activity
        inflater.inflate(R.menu.photo_activity_tb, menu);
        return true;
    }

    //O método abaixo será chamado sempre que um item da ToolBar for selecionado
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opShare:
                //Abaixo determina que caso o ícone de compartilhamento tenha sido clicado, então será executado código que compartilha a foto
                sharePhoto();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void sharePhoto() {
        Uri photoUri = FileProvider.getUriForFile(PhotoActivity.this, "silva.evangelista.santos.wilsiman.galeria.fileprovider", new File(photoPath));
        Intent i = new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_STREAM, photoUri);
        i.setType("image/jpeg");
        startActivity(i);
    }
}