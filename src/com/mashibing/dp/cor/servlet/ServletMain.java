package com.mashibing.dp.cor.servlet;


import java.util.LinkedList;

/**
 * @Auther: LiuJY
 * @Date: 2023/02/04 - 02 - 04 - 23:34
 * @Description: com.mashibing.dp.cor
 * @version: 1.0
 */
public class ServletMain {
    public static void main(String[] args) {
        Request request = new Request();
            request.str = "request";
        Response response = new Response();
            response.str = "response";
    }
}

    //封装变化
    interface Filter{
//        void doFilter(Msg msg);
        boolean doFilter(Request request,Response response);//返回一个布尔值用来判断是否进行下一个过滤
    }

    class HTMLFilter implements Filter{

        @Override
        public boolean doFilter(Request request,Response response ) {
            return false;
        }
    }

    class Request{
        String str;
    }

    class Response{
        String str;
    }



    class SensitiveFilter implements Filter{

        @Override
        public boolean doFilter(Request request,Response response) {
            return false;
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

        public boolean doFilter(Request request,Response response){
            return false;
        }
    }

