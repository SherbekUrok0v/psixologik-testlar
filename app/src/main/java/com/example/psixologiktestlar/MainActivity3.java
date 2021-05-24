package com.example.psixologiktestlar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private Button btn_next;
    private RadioGroup radioGroup;
    private RadioButton radio1, radio2, radio3;
    private TextView tv_question;
    private TextView tv_result;
    private CardView cardView;
    private ImageView imageView;
    private ArrayList<Question2> list;

    int countAll = 0;
    int countResultAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initViews();
        initListQuestions();

        setQuestions(countAll);

        btn_next.setOnClickListener(view -> {
            int id = radioGroup.getCheckedRadioButtonId();
            int answer = 0;
            String a = "";
            switch (id) {
                case R.id.radio1:
                    a = list.get(countAll).getTrueAnswer().substring(0, 1);
                    answer = Integer.parseInt(a);break;
                case R.id.radio2:
                    a = list.get(countAll).getTrueAnswer().substring(1, 2);
                    answer = Integer.parseInt(a);break;
                case R.id.radio3:
                    a = list.get(countAll).getTrueAnswer().substring(2);
                    answer = Integer.parseInt(a);break;
            }
            if (answer != 0) {
                countResultAnswers += answer;
                radioGroup.clearCheck();
                countAll++;
                setQuestions(countAll);
            } else {
                Toast.makeText(MainActivity3.this, "Checked one answer!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setQuestions(int count) {
        if (count >= list.size()) {
            cardView.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);

            if (countResultAnswers >= 10 && count <= 18) {
                tv_result.setText((countResultAnswers + " ball " + "Siz hayotga qora ko‘zoynak orqali boqasiz. Siz hayotingiz baxtli kechmasligiga ishonchingiz komil.Biroq hamisha hayotingizda omadsizliklar yuz bermaydiku! Ko‘proq xushchaqchaq, kelajakka ishonch bilan qaraydigan odamlar davrasida bo‘ling."));
            }
            if (countResultAnswers >= 19 && count <= 24) {
                tv_result.setText((countResultAnswers + " ball " + "Siz har jihatdan yetuk, baxtli insonsiz. Xushmuomalasiz. O‘zingizni tuta bilasiz va qiyin vaziyatlarda sarosimaga tushmaysiz.  "));
            }
            if (countResultAnswers >= 25 && count <= 30) {
                tv_result.setText((countResultAnswers + " ball " + "Siz nihoyatda baxtli insonsiz.Hayotni sevasiz. Kelajakka ishonch bilan boqqaningiz uchun atrofdagilar sizni hurmat qilishadi.Ko‘ngilsizliklar haqida o‘ylashni xohlamaysiz. Biroq vaqti kelib siz hayotga hushyor boqadigan bo‘lasiz."));
            }
            tv_result.setVisibility(View.VISIBLE);
        } else {
            tv_question.setText(list.get(count).getQuestion());
            radio1.setText(list.get(count).getAnswer1());
            radio2.setText(list.get(count).getAnswer2());
            radio3.setText(list.get(count).getAnswer3());
        }
    }

    private void initListQuestions() {
        list = new ArrayList<>();
        list.add(new Question2("Kayfiyatingiz buzilgan chog‘da…", "Tezda o‘zingizga kelishingizni bilasiz", "Biror kishi bilan ziddiyatga bormaslik uchun uydan tashqariga chiqmaysiz", "Biror narsa bilan shug‘ullanishga harakat qilasiz", "213"));
        list.add(new Question2("O‘zingizni boshqalar bilan qiyoslasangiz qanday xulosaga kelasiz?", "Sizda faoliyatingizni yo‘lga qo‘yish uchun barcha fazilatlar mujassam", "Siz boshqalardan qolishmaysiz", "Sizni yetarlicha baholashmayapti", "321"));
        list.add(new Question2("Ertalab uyqudan turgach odatda siz…", "Kechagi kun tafsilotlarini birma-bir hayolingizdan o‘tkazasiz", "Bugungi kun omad keltirishiga ishonasiz", "Yaxshi narsalar haqida o‘y surasiz", "132"));
        list.add(new Question2("Og‘ayningiz ish faoliyatida katta muvaffaqiyatlarga erishdi…", "Menga bunday omad hech qachon nasib etmaydi", "Jin ursin. Nega men unga ergashmadim?!", "Qachonlardir menga ham omad kulib boqadi", "123"));
        list.add(new Question2("Ish kuni yakunida siz odatda …", "Kuningiz bundan ham yaxshi o‘tishi mumkinligi haqida o‘ylaysiz", "Qoniqish tuyg‘usi bilan uyga qaytasiz", "Ishingizdan qoniqmasdan uyga ravona bo‘lasiz", "231"));
        list.add(new Question2("Ko‘zguga boqqanda o‘ylaysiz…", "Hammasi ajoyib", "Vaqt naqadar beshafqat", "Hali hammasi yo‘qotilmagan", "312"));
        list.add(new Question2("Ayrim hollarda o‘tmishingiz haqida o‘ylaganingizda asosan nimani e’tiborga olasiz?", "Yaxshimi yomonmi hayotimning bir qismi o‘tmishga aylandi", "Hamma ajoyib kunlarim o‘tmishga aylandi", "Yomon kunlarim o‘tmishda qolib ketdi", "231"));
        list.add(new Question2("Agar siz ortiqcha vazn to‘plagan bo‘lsangiz…", "Parhezga o‘tirib, jismoniy mashqlarni bajarishga urinasiz", "Xavotirlanish uchun sabab yo‘qligini tushunasiz", "Sarosimaga tushasiz", "321"));
        list.add(new Question2("Do‘stlaringiz haqidagi fikringiz…", "Ularning kamchiliklarini ko‘rsatish shart emas", "Ajoyib insonlar", "Ular men o‘ylaganchalik samimiy emas", "231"));
        list.add(new Question2("Tanishingiz boshiga tushgan falokatni eshitganingizda…", "Xayriyatki, fojea meni chetlab o‘tdi", "Hamdardlik bildirishga oshiqasiz", "Menga buning aloqasi yo‘q", "231"));
    }

    private void initViews() {
        imageView = findViewById(R.id.after_question);
        btn_next = findViewById(R.id.btn_next);
        radioGroup = findViewById(R.id.radioGroup);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        tv_question = findViewById(R.id.tv_question);
        tv_result = findViewById(R.id.tv_result);
        cardView = findViewById(R.id.linear_question);
    }
}