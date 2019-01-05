package com.examplechaiqian.py.mytabrapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PingTaiJieShou extends Activity {

    private View view;

    private TextView textView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




      setContentView(R.layout.pingtaijieshao);

       textView = findViewById(R.id.pingtaitextView);

       textView.setText("\n吉林省崇晟科技有限责任公司\n" +
               "　　旗下中国拆迁网\n" +
               "　　愿景：成为中国知名品牌网络信息化服务公司。\n" +
               "　　精神：崇尚信仰，事业鼎晟。\n" +
               "　　使命：客户、员工、企业、崇晟共赢。\n" +
               "　　口号：崇晟科技，扬帆起航;齐心协力，缔造辉煌。\n" +
               "　　团队：\n" +
               "　　谦虚豁达，使我们赢得团队成员的尊重;\n" +
               "　　着力小事，使我们在团队中出类拔萃;\n" +
               "　　坚持创新，使我们所在的团队与众不同;\n" +
               "　　善于思考，使我们引领团队走出困境;\n" +
               "　　热忱工作，使我们在团队中绩效最高;\n" +
               "　　诚信为本，使我们带领团队无往不利;\n" +
               "　　敬业精神，使我们在团队中展现潜力;\n" +
               "　　尊敬领导，使我们得到更多的机会;\n" +
               "　　忠贞不贰，使我们与团队共命运。\n" +
               "　　   \n我公司竭诚为您的拆迁事业保驾护航 为您提供精准的拆除物资信息 让您感受到业务与利润双倍增的喜悦!\n" +
               "　　   \n中国拆迁网备案许可证编号为：吉ICP备16000017号。中国拆迁网是集传统互联网和移动网络为一体的电子商务交易平台.平台涵盖了中国‘拆迁’行业及拆迁行业衍生出的行业的主体产业，可为企业和个人提供海量的拆迁信息，包括微信(微网站)宣传平台、传统网络(计算机PC)平台两个主体模块，是全面、综合、高效、权威的电子商务交易、应用、服务平台。");


    }

}
