import fitnesse.responders.run.SuiteResponder;
import fitnesse.wiki.*;

public class SetupTeardownIncluder{
    private PageData PageData;
    private boolean isSuite;  //teste unico ou conjunto de paginas de teste
    private WikiPage testPage;
    private StringBuffer newPageContent;
    private PageCrawler pageCrawler; //rastreador de paginas

    public static String render(PageData pageData)throws Exception{
        return render(pageData, false);
    }

    public static String render(PageData pageData, boolean isSuite) throws Exception{
        return new SetupTeardownIncluder(pageData).render(isSuite);
    }

    private SetupTeardownIncluder(PageData pageData){
        this.pageData = pageData;
        testPage = pageData.getWikiPage();
        pageCrawler = testPage.getPageCrawler();
        newPageContent = new StringBuffer();
    }

    private String render(boolean isSuite) throws Exception{
        this.isSuite = isSuite;
        if (isTestPage()){
            includeSetupTeardownPages();
        }
        return pageData.getHtml();
    }

    private boolean isTestPage() throws Exception{
        return pageData.hasAttribute("Test");
    }

    private void includeSetupAndTeardownPages() throws Exception{
        includeSetupPages();
        includePageContent();
        includeTeardownPages();
        updatePageContent();
    }
}
