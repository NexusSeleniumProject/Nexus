package ui.map;

/**
 * Created with IntelliJ IDEA.
 * User: okunev
 * Date: 1/15/14
 * Time: 12:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class NexusMainConsolidatedMap {
    public enum SammaryPage {
        //Main Consolidated Screen
        LNK_FILTER("//nav[@id='topnav']/ul/li/a"),
        LNK_SIDE_MENU("//nav/ul/li/a/span[.='%1$s']//ancestor::a"),
        LNK_LATEST_NEWS_HEADER("//article[@class='top-article']/a/h1"),
        LNK_MOST_POPULAR_ARTICLE("//section/article[1]/ul/li[:?:]/a"),
        LNK_LATEST_BOOKMARK_ARTICLE("//section/article[2]/ul/li[:?:]/a"),
        LNK_LATEST_PRODUCT_ARTICLE("//section/article[3]/ul/li[:?:]/a"),
        LNK_LATEST_RESEARCH_ARTICLE("//section/article[4]/ul/li[:?:]/a"),
        LNK_NEXUS_LOGO("//header/div/h1/a[.=' NEXUS']"),;

        String id;

        private SammaryPage(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public String getId(String number) {
            return id.replace(":?:", number);
        }

    }
}
