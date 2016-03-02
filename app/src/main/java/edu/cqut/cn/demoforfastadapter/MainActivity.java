package edu.cqut.cn.demoforfastadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.dundunwen.FastAdapter;
import com.dundunwen.Impls.LoadImageFromUrlPolicyImpl;

import net.tsz.afinal.FinalBitmap;

import java.util.ArrayList;
import java.util.List;

import edu.cqut.cn.demoforfastadapter.Beans.News;

public class MainActivity extends AppCompatActivity {

    String[] ImageUrls = new String[]{
            "http://img0.imgtn.bdimg.com/it/u=4015889395,3336339825&fm=15&gp=0.jpg",
            "http://www.41443.com/uploads/allimg/150605/14002930a_0.png",
            "http://img2.imgtn.bdimg.com/it/u=2632575719,2283251401&fm=15&gp=0.jpg",
            "http://www.2cto.com/uploadfile/Collfiles/20151020/2015102008494525.png",
            "http://img2.vonibo.com/docin_995973801_110x140.jpg",
            "http://i.kejik.com/1436170139.png",
            "http://www.2cto.com/uploadfile/Collfiles/20150703/20150703083405184.png",
            "http://img4.imgtn.bdimg.com/it/u=451534125,3513318511&fm=15&gp=0.jpg",
            "http://ww2.sinaimg.cn/orj480/736f0c7ejw1exzw84sclej20dc0dcq3s.jpg",
            "http://img.xker.com/xkerfiles/allimg/1501/1339206141-0.jpg",
            "http://www.tkgsh.tn.edu.tw/iEarn/Centerville-Oakwood/2nd-year-2011-2012/album/IMAG3273.jpg",
            "http://img6.paipaiimg.com/00000000/item-51B8DBC7-2619D51200000000040100002D7593FB.0.300x300.jpg",
            "http://d.hiphotos.baidu.com/zhidao/pic/item/908fa0ec08fa513dbd3ecbcc396d55fbb2fbd908.jpg",
            "http://www.tkgsh.tn.edu.tw/iEarn/Centerville-Oakwood/2nd-year-2011-2012/album/IMAG3274.jpg",
            "http://g.hiphotos.baidu.com/zhidao/pic/item/0b55b319ebc4b745ad938baec9fc1e178a821506.jpg",
            "http://e.hiphotos.baidu.com/zhidao/pic/item/3ac79f3df8dcd1000e92c499748b4710b9122f7f.jpg",
            "http://static.open-open.com/lib/uploadImg/20150626/20150626111413_735.png",
            "http://ww2.sinaimg.cn/thumbnail/60e9272ejw1ey200p2sdbj20p90hf76e.jpg",
            "http://www.jcodecraeer.com/uploads/20150413/1428894352835720.png",
            "http://ww2.sinaimg.cn/bmiddle/8e3a1c86jw1esafano3n0j20ki0csq43.jpg"

    };

    RecyclerView rv;
    List<News> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDate();
        initRv();

    }

    private void initRv() {
        rv = (RecyclerView) findViewById(R.id.rv);

        FastAdapter<News> fastAdapter = new FastAdapter<>(R.layout.newslist_item,list,this);
        fastAdapter.setOnItemClickListener(new FastAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, View view) {
                Toast.makeText(MainActivity.this, list.get(position).getNewTitle() + "被单击", Toast.LENGTH_SHORT).show();
            }
        });
        fastAdapter.setOnItemLongClickListener(new FastAdapter.OnItemLongClickListener() {
            @Override
            public void onLongClick(int position, View view) {
                Toast.makeText(MainActivity.this, list.get(position).getNewTitle() + "被长点击", Toast.LENGTH_SHORT).show();
            }
        });
        fastAdapter.setmLoadImageFromUrlPolicyImpl(new LoadImageFromUrlPolicyImpl() {
            @Override
            public void bindImageFormUrl(ImageView view, String url) {
                FinalBitmap finalBitmap = FinalBitmap.create(MainActivity.this);
                finalBitmap.display(view, url);
            }
        });

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setAdapter(fastAdapter);
    }

    public void getDate() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            News n = new News();
            n.setImageUrl(ImageUrls[i]);
            n.setNewTitle("Demo " + i);
            n.setPostTime(i + "小时前");
            list.add(n);
        }
    }
}
