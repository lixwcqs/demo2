package config.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by li on 2015/9/19.
 */
public class MapTest {
    protected static Map<String, Object> map = new HashMap();


    public static void main(String[] args) {
        Page1 page1 = new Page1();
        map.put("currentPage",page1.getCurrentPage());
        map.put("pages",page1.getPages());
        page1.setPages(100);
        page1.setCurrentPage(5);
        System.out.println("currentPage: " + map.get("currentPage"));
        System.out.println("pages: " + map.get("pages"));
    }
}

class Page1  {
    private int currentPage = 1;
    private int pages = 1;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
