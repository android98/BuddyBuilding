package com.example.buddybuilding.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.buddybuilding.R;
import com.example.buddybuilding.adapters.MainGridViewAdapter;
import com.example.buddybuilding.models.JolobazooModel;
import com.example.buddybuilding.models.PaModel;
import com.example.buddybuilding.models.PahlooModel;
import com.example.buddybuilding.models.PoshtbazooModel;
import com.example.buddybuilding.models.SaedModel;
import com.example.buddybuilding.models.SarshooneModel;
import com.example.buddybuilding.models.ShekamModel;
import com.example.buddybuilding.models.ZirbaqalModel;

import io.realm.Realm;


public class MainActivity extends AppCompatActivity {

    GridView gridView;

    public String[] names = {"حرکات سرشانه", "حرکات زیر بقل",
            "حرکات پشت بازو", "حرکات جلو بازو",
            "حرکات شکم ", "حرکات هوازی", "حرکات پهلو",
            "حرکات پا", "حرکات ساعد",};








    public int[] images = {R.drawable.sarshane, R.drawable.zirbaqal, R.drawable.poshtbazoo,
            R.drawable.jolobazo, R.drawable.shekam, R.drawable.havazi, R.drawable.pahloo,
            R.drawable.paaa, R.drawable.saeed};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.grid_view_);
        MainGridViewAdapter adapter =
                new MainGridViewAdapter(this, images, names);
        gridView.setAdapter(adapter);

        Realm realm = Realm.getDefaultInstance();
        final int id = getNextKey(realm);
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {



                ZirbaqalModel model = realm.
                        createObject(ZirbaqalModel.class, id);
                model.setName("زیر بغل  قایقی");
                model.setUrl("https://www.gymextreme.ir/wp-content/uploads/2018/07/Ho" +
                        "w-to-Seated-Cable-Row-with-Hunter-Labrada-Exercise-Guide.mp4");
                model.setInformation("-دسته V را به دستگاه وصل کرده و روی نیمکت می نشینیم.\n" +
                        "۱- دسته را برداشته پاها را به پایه تکیه می دهیم صاف نشسته و شانه ها را عقب می کشیم. زانو ها را کمی خم نگه می داریم.\n" +
                        "۲- بدن را ثابت نگه داشته و دسته را به سمت شکم خود می کشیم.\n" +
                        "۳- شانه ها را عقب کشیده، فشار داده و مکث می کنیم.سپس دوباره به حالت اول بر می گردیم.");


                ShekamModel shekamModel = realm.createObject(ShekamModel.class, id);
                shekamModel.setName("کرانچ با توپ ");
                shekamModel.setUrl("https://hw15.cdn.asset.aparat.com/aparat-video/" +
                        "75044d28f0b94d744f71476c1a950a6911556087-240p__25199.mp4");
                shekamModel.setInformation(" به پشت روی توپ بخوابید و پاهایتان را به اندازه عرض شانه باز کرده و روی زمین قرار دهید.\n" +
                        "    باید در زیر قسمت پایینی پشتتان توپ تناسب اندام قرار گرفته باشد.\n" +
                        "    دست\u200Cهایتان را در پشت گوش قرار دهید و چانه را به سمت داخل جمع کنید.\n" +
                        "    بدنتان را به سمت بالای توپ حلقه کنید و بکشید، تا جایی که به حالت نشسته درآیید.");



                PahlooModel pahlooModel = realm.createObject(PahlooModel.class, id);
                pahlooModel.setName("اسکات وزن بدن");
                pahlooModel.setUrl("https://as2.cdn.asset.aparat.com/aparat-video/62d563755" +
                        "19ffa76c48e6c51747d10056779088-240p__29682.mp4");
                pahlooModel.setInformation("بایستید و پاها را به عرض باسن باز کنید. زانو ها را آرام خم کنید و دستها را به صورت ضربدری روی سینه قرار دهید. به طرف پایین اسکات بروید. وزن را به پاها انتقال دهید. مطمئن شوید پاها مستقیم به سمت جلو بروند و زانو ها درست بالای انگشتان پا قرار بگیرند. کمی نگه دارید و سپس دوباره به حالت اول بازگردید. 5 مرتبه و در هر مرتبه 5 بار انجام دهید.");





                JolobazooModel jolobazooModel = realm.createObject(JolobazooModel.class, id);
                jolobazooModel.setName("آموزش حرکت جلو بازو چکشی دمبل");
                jolobazooModel.setUrl("https://www.gymextreme.ir/wp-content/uploads/2018/05/Standing-Hammer-Curl.mp4");
                jolobazooModel.setInformation("۱-جلو بازو چکشی یکی از بهترین حرکات برای عضلات جلو بازو است.دمبل ها را برداشته و در کنار خود نگه دارید.\n" +
                        "\n" +
                        "۲-بدن را صاف نگه داشته و از حرکت ارنج ها خود داری کنید.به آرامی دمبل ها را تا جایی که ممکن است بلند می کنیم.\n" +
                        "\n" +
                        "۳–در این نقطه عضلات جلو بازو را اندکی فشار داده سپس به آرامی هالتر را پایین می آوریم.");





                PaModel paModel = realm.createObject(PaModel.class, id);
                paModel.setName(" ساق پا هالتر ");
                paModel.setUrl("https://www.gymextreme.ir/wp-content/uploads/2018/04/Rocking-Standing-Calf-Raise.mp4");
                paModel.setInformation("۱-به طور دست باز هالتر را گرفته و بر روی عضلات پشت میگزاریم ، باید دقت کرد که هالتر روی گردن فشار وارد نکند.\n" +
                        "\n" +
                        "۲-بدن صاف و سر به سمت جلو باشد.\n" +
                        "\n" +
                        "۳-به آرامی پاشنه ها از زمین تا جایی که میتوانیم بلند می کنیم.\n" +
                        "\n" +
                        "۴-اندکی مکث کرده سپس پاشنه ها را به آرامی روی زمین میگزاریم.");





                PoshtbazooModel poshtbazooModel = realm.createObject(PoshtbazooModel.class, id);
                poshtbazooModel.setName(" آموزش حرکت پشت بازو دمبل جفتی");
                poshtbazooModel.setUrl("https://www.gymextreme.ir/wp-content/uploads/2018/07/Standing-Overhead-Dumbbell-Tricep-Extension.mp4");
                poshtbazooModel.setInformation("۱- صاف ایستاده و دست ها و پاها را به اندازه عرض شانه باز می کنیم.\n" +
                        "۲- دمبل را برداشته و در دست هایمان نگه می داریم.به طوری که میله دمبل میان انگشت اشاره و شصت هر دو دستمان باشد.\n" +
                        "۳-به آرامی دمبل را بالای سر خود می آوریم. نقطه شروع\n" +
                        "۴-بالای دستهایمان را بی حرکت نگه داشته و با عمل دم دمبل را به آرامی پایین می بریم.\n" +
                        "۵-با بالا آوردن دمبل عمل بازدم اجام می دهیم.");






                SarshooneModel sarshooneModel = realm.createObject(SarshooneModel.class, id);
                sarshooneModel.setName(" پرس سرشانه دستگاه");
                sarshooneModel.setUrl("https://www.gymextreme.ir/wp-content/uploads/2018/07/Machine-Shoulder-Press.mp4");
                sarshooneModel.setInformation("1- روی دستگاه نشسته و دسته ها را میگیریم.پشت دست ها باید به طرف ما باشد.\n" +
                        "\n" +
                        "۲- نفس عمیقی کشیده و دسته ها را مستقیما به بالای سر بلند می کنیم.\n" +
                        "\n" +
                        "۳- به آرامی دسته ها را پایین می آوریم.");





                SaedModel saedModel = realm.createObject(SaedModel.class, id);
                saedModel.setName(" ساعد سیم کش دست بر عکس");
                saedModel.setUrl("https://www.gymextreme.ir/wp-content/up" +
                        "loads/2018/05/Reverse-Grip-Cable-Curl.mp4");

                saedModel.setInformation("۱- دستگاه سیم کش را در پایین تنظیم کرده و میله صاف را وصل می کنیم.\n" +
                        "\n" +
                        "۲- میله را به اندازه عرض شانه گرفته کف دست ها به سمت پایین باشد.\n" +
                        "\n" +
                        "۳- صاف ایستاده، پاها جفت و آرنج ها را نزدیک بدن نگه داشته و اجازه حرکت ندهید .\n" +
                        "\n" +
                        "۴- میله را تا وسط بدن خود بالا می اوریم.نقطه شروع.\n" +
                        "\n" +
                        "۵- میله را تا جایی که ممکن است بالا آورده کمی مکث کرده و دوباره پایین می آوریم.");


            }
        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "" +
                        names[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

    private int getNextKey(Realm realm) {
        try {

            Number number = realm.where(SarshooneModel.class).max("id");
            if (number != null) {
                return number.intValue() + 1;
            } else {
                return 0;
            }

        } catch (ArrayIndexOutOfBoundsException e) {

        }
        return 0;
    }
}
