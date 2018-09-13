package com.xy.study.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo implements Callable<String> {

    private  String id;

    CallableDemo(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "callable test:" + id;
    }
}

class CallAbleTest{

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> listResult = new ArrayList<Future<String>>();

        for (int i = 0; i < 5; i++) {
            listResult.add(exec.submit(new CallableDemo(String.valueOf(i))));
        }

        for (int i = 0; i < listResult.size(); i++) {
            Future<String>  fs =  listResult.get(i);
            try {
                System.err.println("fs result:" + fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
