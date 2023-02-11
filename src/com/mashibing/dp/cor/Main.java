package com.mashibing.dp.cor;

import java.util.LinkedList;

/**
 * @Auther: LiuJY
 * @Date: 2023/02/04 - 02 - 04 - 23:34
 * @Description: com.mashibing.dp.cor
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:),<script>,欢迎访问mashibing.com,大家都是996");

/*        LinkedList<Filter> list = new LinkedList<>();
        list.add(new HTMLFilter());
        list.add(new SensitiveFilter());*/


        FilterChain fc = new FilterChain();
        /*fc.add(new HTMLFilter());
        fc.add(new SensitiveFilter());*/
        //链式编程
        fc.add(new HTMLFilter()).add(new SensitiveFilter());
        fc.doFilter(msg);

        //再来一个链条，然后使FilterChain也实现Filter,这样方便两条链连接
        FilterChain fc2 = new FilterChain();
/*        fc2.add(new FaceFilter()).add(new URLFilter());
        fc2.doFilter(msg);*/

        fc.add(fc2);//将两条链连一块儿了
        fc.doFilter(msg);

        //版本1
        //处理Msg   将下边的处理黑客代码封装起来
       /* String r = msg.getMsg();
        r=r.replace('<','[');
        r=r.replace('>',']');
        msg.setMsg(r);*/

      /*将下边的处理敏感信息封装起来
      r=r.replaceAll("996","995");
        msg.setMsg(r);
*/
        //版本2
       /* new HTMLFilter().doFilter(msg);
        new SensitiveFilter().doFilter(msg);*/

        //版本3  单一链条
       /* for(Filter filter : list){
            filter.doFilter(msg);
        }*/



        System.out.println(msg);
    }

}
    class Msg{

        String name;
        String msg;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "Msg{" +
                    "name='" + name + '\'' +
                    ", msg='" + msg + '\'' +
                    '}';
        }
    }

    //封装变化
    interface Filter{
//        void doFilter(Msg msg);
        boolean doFilter(Msg msg);//返回一个布尔值用来判断是否进行下一个过滤
    }

    class HTMLFilter implements Filter{

        @Override
        public boolean doFilter(Msg m) {
            String r = m.getMsg();
            r=r.replace('<','[');
            r=r.replace('>',']');
            m.setMsg(r);
            return true;
        }
    }

    class SensitiveFilter implements Filter{

        @Override
        public boolean doFilter(Msg m) {
            String r = m.getMsg();
            r=r.replaceAll("996","995");
            m.setMsg(r);
            return false;
        }
    }

    class FaceFilter implements Filter{

        @Override
        public boolean doFilter(Msg msg) {
            String r = msg.getMsg();
            r=r.replace(":)","^V^");
            msg.setMsg(r);
            return true;
        }
    }

    class URLFilter implements Filter{

    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r=r.replace("mashibing.com","http://www.mashibing.com");
        msg.setMsg(r);
        return true;
    }
}


    class FilterChain implements Filter{
        LinkedList<Filter> list = new LinkedList<>();

/*        public void add(Filter filter){
            list.add(filter);
        }*/
        //改进上边的写法，返回一个FilterChain,这样就可用链式编程
        public FilterChain add(Filter filter){
            list.add(filter);
            return this;
        }

        public void remove(Filter filter){
            list.remove(filter);
        }

        public boolean doFilter(Msg msg){
            for (Filter filter : list){
                if(!filter.doFilter(msg)) return false;//如果有一个返回false则停止过滤。
            }
            return true;
        }
    }

