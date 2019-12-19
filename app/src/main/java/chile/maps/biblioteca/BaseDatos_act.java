package chile.maps.biblioteca;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BaseDatos_act extends AppCompatActivity {

    private EditText et1, et2, et3, et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_act);

        et1 = (EditText)findViewById(R.id.codigo);
        et2 = (EditText)findViewById(R.id.nombre);
        et3 = (EditText)findViewById(R.id.precio);
        et4 = (EditText)findViewById(R.id.precio);
    }

    public void añadirOrd(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Biblioteca", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!et1.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo", et1.getText().toString());
            registro.put("nombre", et2.getText().toString());
            registro.put("precio", et3.getText().toString());
            registro.put("precios", et4.getText().toString());

            BaseDeDatos.insert("Libros", null, registro);
            BaseDeDatos.close();

            Toast.makeText(this, "Se registro un Libro", Toast.LENGTH_LONG).show();
        }
    }
}

