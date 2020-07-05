package br.sofex.com.easypermission;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * permissions request code
     */
    private static final int READ_REQUEST_CODE = 200;
    static final int REQUEST_IMGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 2;
    static final int CAM_REQUEST = 3;

    /**
     * Permissions that need to be explicitly requested from end user.
     */
    private static final String[] REQUIRED_SDK_PERMISSIONS = new String[] { Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //check if app has permission to access the external storage.
       /* if (EasyPermissions.hasPermissions(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //TODO: Chama e Função
        } else {
            //If permission is not present request for the same.
            EasyPermissions.requestPermissions(MainActivity.this,"Este aplicativo precisa acessar a câmera para prosseguir . Por favor autorize o acesso a câmera.",READ_REQUEST_CODE,Manifest.permission.READ_EXTERNAL_STORAGE);
        }*/

        Permissao permissao = new Permissao(MainActivity.this);
        Toast.makeText(this, "Result :"+permissao.checkpermissao(), Toast.LENGTH_SHORT).show();

    }

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // now, you have permission go ahead
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_TAKE_PHOTO);

        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_CALL_LOG)) {
                EasyPermissions.requestPermissions(MainActivity.this, "Este aplicativo precisa acessar a câmera para prosseguir . Por favor autorize o acesso a câmera.", READ_REQUEST_CODE, Manifest.permission.READ_EXTERNAL_STORAGE);
            } else {

                // now, user has denied permission permanently!

                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Voçê negou o acesso ao aplicativo.\n" +
                  "Você precissa aprovar a(s) permissão(ôes)", Snackbar.LENGTH_LONG).setAction("Alterar", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                   startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + BuildConfig.APPLICATION_ID)));

                    }
                });
                snackbar.show();
            }

        }
    }*/

}
