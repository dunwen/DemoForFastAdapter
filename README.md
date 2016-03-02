# 快速配置RecyclerView的Adapter

额，水平低，轻喷

# 怎么使用

##javaBean中

    @BindId(Id = R.id.newlist_title,ViewType = TextView.class)
    String newTitle;

    @BindId(Id = R.id.newlist_time,ViewType = TextView.class)
    String postTime;

    @BindId(Id = R.id.newlist_headimage,ViewType = ImageView.class)
    String ImageUrl;
    

## Activity中
        rv = (RecyclerView) findViewById(R.id.rv);

        FastAdapter<News> fastAdapter = new FastAdapter<>(R.layout.newslist_item,list,this);
		
        //配置单击事件
		fastAdapter.setOnItemClickListener(new FastAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, View view) {
                Toast.makeText(MainActivity.this, list.get(position).getNewTitle() + "被单击", Toast.LENGTH_SHORT).show();
            }
        });
        
        //配置长按事件
        fastAdapter.setOnItemLongClickListener(new FastAdapter.OnItemLongClickListener() {
            @Override
            public void onLongClick(int position, View view) {
                Toast.makeText(MainActivity.this, list.get(position).getNewTitle() + "被长点击", Toast.LENGTH_SHORT).show();
            }
        });
        
        //配置从网络下载图片的策略
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
        
        
## 对于第三方控件
需要使用如下注解
    @BindId(Id = R.id.imageView,ViewType = de.hdodenhof.circleimageview.CircleImageView.class,BindDateMethodName = 	    "setImageBitmap")
    Bitmap icon;
