
package finalprojectB;
import junit.framework.TestCase;
import java.io.*;
import java.util.Scanner;

/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1739358 $
 */







public class UrlValidatorTest extends TestCase {

   private final boolean printStatus = false;
   private final boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   //@Override


   public void testManualTest()
   {    UrlValidator urlVal = new UrlValidator(null, null, 1);

       System.out.println("\nBasically  manual test for finding probably errors");
       System.out.println("1 " + urlVal.isValid("http://www.mx.iucr.org/iucr-top/comm/cpd/QARR/raw/cpd-1a.raw"));
       System.out.println("2 " + urlVal.isValid("http://0.0.0.0/$23?action=view"));
       System.out.println("3 " + urlVal.isValid("http://sdpd.univ-lemans.fr/course/week-1/sample1.uxd"));
       System.out.println("4 " + urlVal.isValid("http://mysite.du.edu/~balzar/lebailbr.dbw"));

       System.out.println("5 " +  urlVal.isValid("http://0.0.0.0?~action=edit&mode=up"));
       System.out.println("6 " +  urlVal.isValid("http://go.au:65535/test1/"));
       System.out.println("7 " +  urlVal.isValid("http://www.google.com:80/test1?action=edit&mode=up"));
       System.out.println("8 " +  urlVal.isValid("http://go.com:0?action=edit&mode=up"));
       System.out.println("9 " +  urlVal.isValid("http://0.0.0.0:65535/test1/file?action=view"));

       System.out.println("10 " +  urlVal.isValid("http://sellercentral.amazon.com"));
       System.out.println("11 " +  urlVal.isValid("http://yardstick.pictures/"));
       System.out.println("12 " +  urlVal.isValid("http://superuser.com/questions/461402/is-there-any-server-provides-image-url-for-testing"));
       System.out.println("13 " +  urlVal.isValid("http://superuser.com/users/login?ssrc=head&returnurl=https%3a%2f%2fsuperuser.com%2f"));
       System.out.println("14 " +  urlVal.isValid("http://0.0.0.0?action=edit&mode=up"));
       System.out.println("15 " +  urlVal.isValid("http://255.255.255.255:65535?action=edit&mode=up"));
       System.out.println("16 " +  urlVal.isValid("http://255.255.255.255:0/test1/?action=edit&mode=up"));
       System.out.println("17 " +  urlVal.isValid("http://255.com/$23?action=edit&mode=up"));
       System.out.println("18 " +  urlVal.isValid("http://www.google.com:65535?action=edit&mode=up"));
       System.out.println("19 " +  urlVal.isValid("http://www.google.com:80/$23"));
       System.out.println("20 " +  urlVal.isValid("http://go.com/test1/file?action=edit&mode=up"));

       System.out.println("e1 " + urlVal.isValid("http://.aaa/t123?action=edit&mode=up"));
       System.out.println("e2 " + urlVal.isValid("http:///t123"));///this is an incorrect url but show true.
       System.out.println("e3 " + urlVal.isValid("http://256.256.256.256/$23?action=edit&mode=up"));
       System.out.println("e4 " + urlVal.isValid("http://1.2.3/t123?action=edit&mode=up"));
       System.out.println("e5 " +  urlVal.isValid("http://some-domain/image6.jpg"));



       System.out.println("\nnew test for contain : ");
       //add test for 11a, and 12a
       System.out.println("11a " +  urlVal.isValid("http://www.google.com:80/?action=edit&mode=up"));
       System.out.println("11b " +  urlVal.isValid("http://www.google.com/?action=edit&mode=up"));
       System.out.println("12a " +  urlVal.isValid("http://go.com:0/?action=edit&mode=up"));
       System.out.println("12b " +  urlVal.isValid("http://go.com/?action=edit&mode=up"));


       System.out.println("------------------------------------------------------------------------");

       System.out.println("11a scheme " +  urlVal.isValidScheme("http"));
     //  System.out.println("11a authority " +  urlVal.isValidAuthority("www.google.com"));
      // System.out.println("11a authority and port " +  urlVal.isValidAuthority("www.google.com:80"));
       System.out.println("11a query " +  urlVal.isValidQuery("?action=edit&mode=up"));

       System.out.println("12a scheme " +  urlVal.isValidScheme("http"));
      // System.out.println("12a authority " +  urlVal.isValidAuthority("go.com"));
      // System.out.println("12a authority and port " +  urlVal.isValidAuthority("go.com:80"));
       System.out.println("12a query " +  urlVal.isValidQuery("?action=edit&mode=up"));






       System.out.println("\nnew test for contain ~");

       System.out.println("11a " +  urlVal.isValid("http://www.google.com/~test1"));
       System.out.println("11b " +  urlVal.isValid("http://www.google.com/test1"));
       System.out.println("12a " +  urlVal.isValid("http://go.com/~test1"));
       System.out.println("12b " +  urlVal.isValid("http://go.com/test1"));
       System.out.println("------------------------------------------------------------------------");
       System.out.println("11a scheme " +  urlVal.isValidScheme("http"));//expected true
      // System.out.println("11a authority " +  urlVal.isValidAuthority("www.google.com"));
       System.out.println("11a path " +  urlVal.isValidPath("/test1"));
       System.out.println("11a path " +  urlVal.isValidPath("/~test1"));







       String TEST_1 = "http://www.google.com";//:80/test1/?action=view";
    //  String TEST_2 = "file:///Users/maoyihui/";

      //UrlValidator urlVal = new UrlValidator(null, allowAllSchemes);

      urlVal.isValid( TEST_1);
    //  urlVal.isValid( TEST_2);
      assertTrue(urlVal.isValid( TEST_1));
      //assertTrue(urlVal.isValid( TEST_2));

      System.out.println("the string array have ");


   }


// I throw all the correct valid url into the SystematicTest to check the validity. I find that the only http url printed out.
// but other urls do not printed out. Because I only want to print the right url, even if there are bugs in UrlValidator,
//    the right url starting with other scheme also would be print out, but the reality is not. I think this due to two
    // reason one is all other schemes url are wrong, but it is not very possible, the other reason is there is bugs when
    // initialization when i call is valid, and the blue link in error report also may prove it. I will check http ftp and h3t
    // respectly.

/*
    public void testAllUrl ()
    {

  System.out.println("------------------START SYSTEM TEST----------------");
        int a=0;
        while(System_url[a]!="h3t://255.com/test1/file") {
            a++;
        }
        System.out.println("the string array have "+a);

        UrlValidator urlVal = new UrlValidator(null, null, 1);


        for(int i=0;i<=a;i++) {
            if(urlVal.isValid(System_url[i])!=true)
                System.out.println("the url:"+ System_url[i]+" do not match the expected value" );
        }
    }



*/




   public void testYourFirstPartition ()
   {
      //You can use this function to implement your First Partition testing
       System.out.println("------------------START Partition TEST http scheme----------------");
   int a=0;
      while(right_url[a]!="http://go.au/test1/file") {
         a++;
      }
System.out.println("the string array have "+a);

      UrlValidator urlVal = new UrlValidator(null, null, 1);

     // for(int i=0;i<=a;i++) {
     //    assertTrue(urlVal.isValid(right_url[i]));
     // }
      for(int i=0;i<=a;i++) {
      if(urlVal.isValid(right_url[i])!=true)
      System.out.println("the url:"+ right_url[i]+" do not match the expected value" );
      }
   }




/*

   public void testYourSecondPartition(){
      //You can use this function to implement your Second Partition testing
       System.out.println("------------------START Partition TEST ftp scheme----------------");
       int a=0;
       while(right_ftp[a]!="ftp://go.au/test1/file") {
           a++;
       }
       System.out.println("the string array have "+a);

       UrlValidator urlVal = new UrlValidator(null, null, 1);

       // for(int i=0;i<=a;i++) {
       //    assertTrue(urlVal.isValid(right_url[i]));
       // }
       for(int i=0;i<=a;i++) {
           if(urlVal.isValid(right_ftp[i])!=true)
               System.out.println("the url:"+ right_ftp[i]+" do not match the expected value" );
       }

   }

*/


/*
    public void testYourThirdPartition(){
        //You can use this function to implement your Second Partition testing
        System.out.println("------------------START Partition TEST h3t scheme----------------");

        int a=0;
        while(right_h3t[a]!="h3t://255.com/test1/file") {
            a++;
    }
        System.out.println("the string array have "+a);

        UrlValidator urlVal = new UrlValidator(null, null, 1);

        // for(int i=0;i<=a;i++) {
        //    assertTrue(urlVal.isValid(right_domain_withoutport[i]));
        // }
        for(int i=0;i<=a;i++) {
            if(urlVal.isValid(right_h3t[i])!=true)
                System.out.println("the url:"+ right_h3t[i]+" do not match the expected value" );
        }

    }

*/
//as we see the approched screenshot only url staring with http can be print out, and based on the blue link showned in
// in error report. when call isvalid(correct_ftp_url )  and  isvalid(correct_ftp_url ) would lead build failure because of
// error in the stage of initializtion, then I would start to test http url



    // based on the obersevrtion,


    public void testYourFourthPartition() {
        System.out.println("------------------START Partition TEST HTTP scheme only with :port ----------------");
        int a = 0;
        while (http_url_with_port[a] != "http://go.au:80/test1/file") {
            a++;
        }

        System.out.println("the string array have " + a);
        UrlValidator urlVal = new UrlValidator(null, null, 1);
        int i;
        int z = 0;
        for (i = 0; i <a; i++) {
            if (urlVal.isValid(http_url_with_port[i]) != true) {
                System.out.println("the url:" + http_url_with_port[i] + " do not match the expected value");
                z++;
            }
        }

        System.out.println("the # of error" + z);
        System.out.println("------------------START manual_test_for_http_with_port---------------");

        if (urlVal.isValid("http://www.google.com:80") != true) {
            System.out.println("http://www.google.com:80 is valid url , but it is invalid tested by this code, " +
                    "so I separate the url into scheme and authority, and also test http://www.google.com");
        }
        if (urlVal.isValid("http://www.google.com") != true) {
            System.out.println("http://www.google.com is valid, but it is invalid ");
        }
        if (urlVal.isValidScheme("http") == true) {
            System.out.println("the scheme http:// is true");
        }

    }
        /*
        if(urlVal.isValidAuthority("www.google.com")!=true){
            System.out.println("www.google.com is valid, but it is invalid, " +
                    "which is because of the port validator");
        }
*/



/*
        if(urlVal.isValidAuthority("www.google.com:80")!=true){
            System.out.println("www.google.com:80 is valid, but it is invalid, " +
                    "which is because of the port validator");
        }
*/





    // if I pass all http scheme urls which is with port number  into  urlVal.isValild(), count the # of the kind of
    // url, which is 63, then also count # of invalid  urls in this kind of urls, which is also 63. It means the most
    // possible that the http with port is invalid. I would use unit test to check, and review it in code.







   public void testValidateUrl() {
   //   assertTrue(true);
   }

   /**
    * Only used to debug the unit tests.
    * @param argv
    */
   public static void main(String[] argv) throws Exception{




      UrlValidatorTest fct = new UrlValidatorTest("url test");


       fct.testManualTest();

       //fct.testAllUrl();

       fct.testYourFirstPartition ();     // test the url  starting with http
       //  fct.testYourSecondPartition(); // test the url  starting with ftp
       //  fct.testYourThirdPartition();  // test the url  starting with h3t
       fct.testYourFourthPartition();    //  test the url  starting with http and with port number :XX


   }

    String [] System_url={
            "http://www.google.com:80/test1?action=view",
            "http://www.google.com:80/test1?action=edit&mode=up",
            "http://www.google.com:80/test1",
            "http://www.google.com:80/t123?action=view",
            "http://www.google.com:80/t123?action=edit&mode=up",
            "http://www.google.com:80/t123",
            "http://www.google.com:80/$23?action=view",
            "http://www.google.com:80/$23?action=edit&mode=up",
            "http://www.google.com:80/$23",
            "http://www.google.com:80/test1/?action=view",
            "http://www.google.com:80/test1/?action=edit&mode=up",
            "http://www.google.com:80/test1/",
            "http://www.google.com:80?action=view",
            "http://www.google.com:80?action=edit&mode=up",
            "http://www.google.com:80",
            "http://www.google.com:80/test1/file?action=view",
            "http://www.google.com:80/test1/file?action=edit&mode=up",
            "http://www.google.com:80/test1/file",
            "http://www.google.com:80/~test1/file?action=view",
            "http://www.google.com:80/~test1/file?action=edit&mode=up",
            "http://www.google.com:80/~test1/file",
            "http://www.google.com/test1?action=view",
            "http://www.google.com/test1?action=edit&mode=up",
            "http://www.google.com/test1",
            "http://www.google.com/t123?action=view",
            "http://www.google.com/t123?action=edit&mode=up",
            "http://www.google.com/t123",
            "http://www.google.com/$23?action=view",
            "http://www.google.com/$23?action=edit&mode=up",
            "http://www.google.com/$23",
            "http://www.google.com/test1/?action=view",
            "http://www.google.com/test1/?action=edit&mode=up",
            "http://www.google.com/test1/",
            "http://www.google.com?action=view",
            "http://www.google.com?action=edit&mode=up",
            "http://www.google.com",
            "http://www.google.com/test1/file?action=view",
            "http://www.google.com/test1/file?action=edit&mode=up",
            "http://www.google.com/test1/file",
            "http://www.google.com/~test1/file?action=view",
            "http://www.google.com/~test1/file?action=edit&mode=up",
            "http://www.google.com/~test1/file",
            "http://go.com:80/test1?action=view",
            "http://go.com:80/test1?action=edit&mode=up",
            "http://go.com:80/test1",
            "http://go.com:80/t123?action=view",
            "http://go.com:80/t123?action=edit&mode=up",
            "http://go.com:80/t123",
            "http://go.com:80/$23?action=view",
            "http://go.com:80/$23?action=edit&mode=up",
            "http://go.com:80/$23",
            "http://go.com:80/test1/?action=view",
            "http://go.com:80/test1/?action=edit&mode=up",
            "http://go.com:80/test1/",
            "http://go.com:80?action=view",
            "http://go.com:80?action=edit&mode=up",
            "http://go.com:80",
            "http://go.com:80/test1/file?action=view",
            "http://go.com:80/test1/file?action=edit&mode=up",
            "http://go.com:80/test1/file",
            "http://go.com:80/~test1/file?action=view",
            "http://go.com:80/~test1/file?action=edit&mode=up",
            "http://go.com:80/~test1/file",
            "http://go.com/test1?action=view",
            "http://go.com/test1?action=edit&mode=up",
            "http://go.com/test1",
            "http://go.com/t123?action=view",
            "http://go.com/t123?action=edit&mode=up",
            "http://go.com/t123",
            "http://go.com/$23?action=view",
            "http://go.com/$23?action=edit&mode=up",
            "http://go.com/$23",
            "http://go.com/test1/?action=view",
            "http://go.com/test1/?action=edit&mode=up",
            "http://go.com/test1/",
            "http://go.com?action=view",
            "http://go.com?action=edit&mode=up",
            "http://go.com",
            "http://go.com/test1/file?action=view",
            "http://go.com/test1/file?action=edit&mode=up",
            "http://go.com/test1/file",
            "http://go.com/~test1/file?action=view",
            "http://go.com/~test1/file?action=edit&mode=up",
            "http://go.com/~test1/file",
            "http://go.au:80/test1?action=view",
            "http://go.au:80/test1?action=edit&mode=up",
            "http://go.au:80/test1",
            "http://go.au:80/t123?action=view",
            "http://go.au:80/t123?action=edit&mode=up",
            "http://go.au:80/t123",
            "http://go.au:80/$23?action=view",
            "http://go.au:80/$23?action=edit&mode=up",
            "http://go.au:80/$23",
            "http://go.au:80/test1/?action=view",
            "http://go.au:80/test1/?action=edit&mode=up",
            "http://go.au:80/test1/",
            "http://go.au:80?action=view",
            "http://go.au:80?action=edit&mode=up",
            "http://go.au:80",
            "http://go.au:80/test1/file?action=view",
            "http://go.au:80/test1/file?action=edit&mode=up",
            "http://go.au:80/test1/file",
            "http://go.au:80/~test1/file?action=view",
            "http://go.au:80/~test1/file?action=edit&mode=up",
            "http://go.au:80/~test1/file",
            "http://go.au/test1?action=view",
            "http://go.au/test1?action=edit&mode=up",
            "http://go.au/test1",
            "http://go.au/t123?action=view",
            "http://go.au/t123?action=edit&mode=up",
            "http://go.au/t123",
            "http://go.au/$23?action=view",
            "http://go.au/$23?action=edit&mode=up",
            "http://go.au/$23",
            "http://go.au/test1/?action=view",
            "http://go.au/test1/?action=edit&mode=up",
            "http://go.au/test1/",
            "http://go.au?action=view",
            "http://go.au?action=edit&mode=up",
            "http://go.au",
            "http://go.au/test1/file?action=view",
            "http://go.au/test1/file?action=edit&mode=up",
            "http://go.au/test1/file",
            "http://go.au/~test1/file?action=view",
            "http://go.au/~test1/file?action=edit&mode=up",
            "http://go.au/~test1/file",
            "http://0.0.0.0:80/test1?action=view",
            "http://0.0.0.0:80/test1?action=edit&mode=up",
            "http://0.0.0.0:80/test1",
            "http://0.0.0.0:80/t123?action=view",
            "http://0.0.0.0:80/t123?action=edit&mode=up",
            "http://0.0.0.0:80/t123",
            "http://0.0.0.0:80/$23?action=view",
            "http://0.0.0.0:80/$23?action=edit&mode=up",
            "http://0.0.0.0:80/$23",
            "http://0.0.0.0:80/test1/?action=view",
            "http://0.0.0.0:80/test1/?action=edit&mode=up",
            "http://0.0.0.0:80/test1/",
            "http://0.0.0.0:80?action=view",
            "http://0.0.0.0:80?action=edit&mode=up",
            "http://0.0.0.0:80",
            "http://0.0.0.0:80/test1/file?action=view",
            "http://0.0.0.0:80/test1/file?action=edit&mode=up",
            "http://0.0.0.0:80/test1/file",
            "http://0.0.0.0:80/~test1/file?action=view",
            "http://0.0.0.0:80/~test1/file?action=edit&mode=up",
            "http://0.0.0.0:80/~test1/file",
            "http://0.0.0.0/test1?action=view",
            "http://0.0.0.0/test1?action=edit&mode=up",
            "http://0.0.0.0/test1",
            "http://0.0.0.0/t123?action=view",
            "http://0.0.0.0/t123?action=edit&mode=up",
            "http://0.0.0.0/t123",
            "http://0.0.0.0/$23?action=view",
            "http://0.0.0.0/$23?action=edit&mode=up",
            "http://0.0.0.0/$23",
            "http://0.0.0.0/test1/?action=view",
            "http://0.0.0.0/test1/?action=edit&mode=up",
            "http://0.0.0.0/test1/",
            "http://0.0.0.0?action=view",
            "http://0.0.0.0?action=edit&mode=up",
            "http://0.0.0.0",
            "http://0.0.0.0/test1/file?action=view",
            "http://0.0.0.0/test1/file?action=edit&mode=up",
            "http://0.0.0.0/test1/file",
            "http://0.0.0.0/~test1/file?action=view",
            "http://0.0.0.0/~test1/file?action=edit&mode=up",
            "http://0.0.0.0/~test1/file",
            "http://255.255.255.255:80/test1?action=view",
            "http://255.255.255.255:80/test1?action=edit&mode=up",
            "http://255.255.255.255:80/test1",
            "http://255.255.255.255:80/t123?action=view",
            "http://255.255.255.255:80/t123?action=edit&mode=up",
            "http://255.255.255.255:80/t123",
            "http://255.255.255.255:80/$23?action=view",
            "http://255.255.255.255:80/$23?action=edit&mode=up",
            "http://255.255.255.255:80/$23",
            "http://255.255.255.255:80/test1/?action=view",
            "http://255.255.255.255:80/test1/?action=edit&mode=up",
            "http://255.255.255.255:80/test1/",
            "http://255.255.255.255:80?action=view",
            "http://255.255.255.255:80?action=edit&mode=up",
            "http://255.255.255.255:80",
            "http://255.255.255.255:80/test1/file?action=view",
            "http://255.255.255.255:80/test1/file?action=edit&mode=up",
            "http://255.255.255.255:80/test1/file",
            "http://255.255.255.255:80/~test1/file?action=view",
            "http://255.255.255.255:80/~test1/file?action=edit&mode=up",
            "http://255.255.255.255:80/~test1/file",
            "http://255.255.255.255/test1?action=view",
            "http://255.255.255.255/test1?action=edit&mode=up",
            "http://255.255.255.255/test1",
            "http://255.255.255.255/t123?action=view",
            "http://255.255.255.255/t123?action=edit&mode=up",
            "http://255.255.255.255/t123",
            "http://255.255.255.255/$23?action=view",
            "http://255.255.255.255/$23?action=edit&mode=up",
            "http://255.255.255.255/$23",
            "http://255.255.255.255/test1/?action=view",
            "http://255.255.255.255/test1/?action=edit&mode=up",
            "http://255.255.255.255/test1/",
            "http://255.255.255.255?action=view",
            "http://255.255.255.255?action=edit&mode=up",
            "http://255.255.255.255",
            "http://255.255.255.255/test1/file?action=view",
            "http://255.255.255.255/test1/file?action=edit&mode=up",
            "http://255.255.255.255/test1/file",
            "http://255.255.255.255/~test1/file?action=view",
            "http://255.255.255.255/~test1/file?action=edit&mode=up",
            "http://255.255.255.255/~test1/file",
            "http://255.com:80/test1?action=view",
            "http://255.com:80/test1?action=edit&mode=up",
            "http://255.com:80/test1",
            "http://255.com:80/t123?action=view",
            "http://255.com:80/t123?action=edit&mode=up",
            "http://255.com:80/t123",
            "http://255.com:80/$23?action=view",
            "http://255.com:80/$23?action=edit&mode=up",
            "http://255.com:80/$23",
            "http://255.com:80/test1/?action=view",
            "http://255.com:80/test1/?action=edit&mode=up",
            "http://255.com:80/test1/",
            "http://255.com:80?action=view",
            "http://255.com:80?action=edit&mode=up",
            "http://255.com:80",
            "http://255.com:80/test1/file?action=view",
            "http://255.com:80/test1/file?action=edit&mode=up",
            "http://255.com:80/test1/file",
            "http://255.com:80/~test1/file?action=view",
            "http://255.com:80/~test1/file?action=edit&mode=up",
            "http://255.com:80/~test1/file",
            "http://255.com/test1?action=view",
            "http://255.com/test1?action=edit&mode=up",
            "http://255.com/test1",
            "http://255.com/t123?action=view",
            "http://255.com/t123?action=edit&mode=up",
            "http://255.com/t123",
            "http://255.com/$23?action=view",
            "http://255.com/$23?action=edit&mode=up",
            "http://255.com/$23",
            "http://255.com/test1/?action=view",
            "http://255.com/test1/?action=edit&mode=up",
            "http://255.com/test1/",
            "http://255.com?action=view",
            "http://255.com?action=edit&mode=up",
            "http://255.com",
            "http://255.com/test1/file?action=view",
            "http://255.com/test1/file?action=edit&mode=up",
            "http://255.com/test1/file",
            "http://255.com/~test1/file?action=view",
            "http://255.com/~test1/file?action=edit&mode=up",
            "http://255.com/~test1/file",
            "ftp://www.google.com:80/test1?action=view",
            "ftp://www.google.com:80/test1?action=edit&mode=up",
            "ftp://www.google.com:80/test1",
            "ftp://www.google.com:80/t123?action=view",
            "ftp://www.google.com:80/t123?action=edit&mode=up",
            "ftp://www.google.com:80/t123",
            "ftp://www.google.com:80/$23?action=view",
            "ftp://www.google.com:80/$23?action=edit&mode=up",
            "ftp://www.google.com:80/$23",
            "ftp://www.google.com:80/test1/?action=view",
            "ftp://www.google.com:80/test1/?action=edit&mode=up",
            "ftp://www.google.com:80/test1/",
            "ftp://www.google.com:80?action=view",
            "ftp://www.google.com:80?action=edit&mode=up",
            "ftp://www.google.com:80",
            "ftp://www.google.com:80/test1/file?action=view",
            "ftp://www.google.com:80/test1/file?action=edit&mode=up",
            "ftp://www.google.com:80/test1/file",
            "ftp://www.google.com:80/~test1/file?action=view",
            "ftp://www.google.com:80/~test1/file?action=edit&mode=up",
            "ftp://www.google.com:80/~test1/file",
            "ftp://www.google.com/test1?action=view",
            "ftp://www.google.com/test1?action=edit&mode=up",
            "ftp://www.google.com/test1",
            "ftp://www.google.com/t123?action=view",
            "ftp://www.google.com/t123?action=edit&mode=up",
            "ftp://www.google.com/t123",
            "ftp://www.google.com/$23?action=view",
            "ftp://www.google.com/$23?action=edit&mode=up",
            "ftp://www.google.com/$23",
            "ftp://www.google.com/test1/?action=view",
            "ftp://www.google.com/test1/?action=edit&mode=up",
            "ftp://www.google.com/test1/",
            "ftp://www.google.com?action=view",
            "ftp://www.google.com?action=edit&mode=up",
            "ftp://www.google.com",
            "ftp://www.google.com/test1/file?action=view",
            "ftp://www.google.com/test1/file?action=edit&mode=up",
            "ftp://www.google.com/test1/file",
            "ftp://www.google.com/~test1/file?action=view",
            "ftp://www.google.com/~test1/file?action=edit&mode=up",
            "ftp://www.google.com/~test1/file",
            "ftp://go.com:80/test1?action=view",
            "ftp://go.com:80/test1?action=edit&mode=up",
            "ftp://go.com:80/test1",
            "ftp://go.com:80/t123?action=view",
            "ftp://go.com:80/t123?action=edit&mode=up",
            "ftp://go.com:80/t123",
            "ftp://go.com:80/$23?action=view",
            "ftp://go.com:80/$23?action=edit&mode=up",
            "ftp://go.com:80/$23",
            "ftp://go.com:80/test1/?action=view",
            "ftp://go.com:80/test1/?action=edit&mode=up",
            "ftp://go.com:80/test1/",
            "ftp://go.com:80?action=view",
            "ftp://go.com:80?action=edit&mode=up",
            "ftp://go.com:80",
            "ftp://go.com:80/test1/file?action=view",
            "ftp://go.com:80/test1/file?action=edit&mode=up",
            "ftp://go.com:80/test1/file",
            "ftp://go.com:80/~test1/file?action=view",
            "ftp://go.com:80/~test1/file?action=edit&mode=up",
            "ftp://go.com:80/~test1/file",
            "ftp://go.com/test1?action=view",
            "ftp://go.com/test1?action=edit&mode=up",
            "ftp://go.com/test1",
            "ftp://go.com/t123?action=view",
            "ftp://go.com/t123?action=edit&mode=up",
            "ftp://go.com/t123",
            "ftp://go.com/$23?action=view",
            "ftp://go.com/$23?action=edit&mode=up",
            "ftp://go.com/$23",
            "ftp://go.com/test1/?action=view",
            "ftp://go.com/test1/?action=edit&mode=up",
            "ftp://go.com/test1/",
            "ftp://go.com?action=view",
            "ftp://go.com?action=edit&mode=up",
            "ftp://go.com",
            "ftp://go.com/test1/file?action=view",
            "ftp://go.com/test1/file?action=edit&mode=up",
            "ftp://go.com/test1/file",
            "ftp://go.com/~test1/file?action=view",
            "ftp://go.com/~test1/file?action=edit&mode=up",
            "ftp://go.com/~test1/file",
            "ftp://go.au:80/test1?action=view",
            "ftp://go.au:80/test1?action=edit&mode=up",
            "ftp://go.au:80/test1",
            "ftp://go.au:80/t123?action=view",
            "ftp://go.au:80/t123?action=edit&mode=up",
            "ftp://go.au:80/t123",
            "ftp://go.au:80/$23?action=view",
            "ftp://go.au:80/$23?action=edit&mode=up",
            "ftp://go.au:80/$23",
            "ftp://go.au:80/test1/?action=view",
            "ftp://go.au:80/test1/?action=edit&mode=up",
            "ftp://go.au:80/test1/",
            "ftp://go.au:80?action=view",
            "ftp://go.au:80?action=edit&mode=up",
            "ftp://go.au:80",
            "ftp://go.au:80/test1/file?action=view",
            "ftp://go.au:80/test1/file?action=edit&mode=up",
            "ftp://go.au:80/test1/file",
            "ftp://go.au:80/~test1/file?action=view",
            "ftp://go.au:80/~test1/file?action=edit&mode=up",
            "ftp://go.au:80/~test1/file",
            "ftp://go.au/test1?action=view",
            "ftp://go.au/test1?action=edit&mode=up",
            "ftp://go.au/test1",
            "ftp://go.au/t123?action=view",
            "ftp://go.au/t123?action=edit&mode=up",
            "ftp://go.au/t123",
            "ftp://go.au/$23?action=view",
            "ftp://go.au/$23?action=edit&mode=up",
            "ftp://go.au/$23",
            "ftp://go.au/test1/?action=view",
            "ftp://go.au/test1/?action=edit&mode=up",
            "ftp://go.au/test1/",
            "ftp://go.au?action=view",
            "ftp://go.au?action=edit&mode=up",
            "ftp://go.au",
            "ftp://go.au/test1/file?action=view",
            "ftp://go.au/test1/file?action=edit&mode=up",
            "ftp://go.au/test1/file",
            "ftp://go.au/~test1/file?action=view",
            "ftp://go.au/~test1/file?action=edit&mode=up",
            "ftp://go.au/~test1/file",
            "ftp://0.0.0.0:80/test1?action=view",
            "ftp://0.0.0.0:80/test1?action=edit&mode=up",
            "ftp://0.0.0.0:80/test1",
            "ftp://0.0.0.0:80/t123?action=view",
            "ftp://0.0.0.0:80/t123?action=edit&mode=up",
            "ftp://0.0.0.0:80/t123",
            "ftp://0.0.0.0:80/$23?action=view",
            "ftp://0.0.0.0:80/$23?action=edit&mode=up",
            "ftp://0.0.0.0:80/$23",
            "ftp://0.0.0.0:80/test1/?action=view",
            "ftp://0.0.0.0:80/test1/?action=edit&mode=up",
            "ftp://0.0.0.0:80/test1/",
            "ftp://0.0.0.0:80?action=view",
            "ftp://0.0.0.0:80?action=edit&mode=up",
            "ftp://0.0.0.0:80",
            "ftp://0.0.0.0:80/test1/file?action=view",
            "ftp://0.0.0.0:80/test1/file?action=edit&mode=up",
            "ftp://0.0.0.0:80/test1/file",
            "ftp://0.0.0.0:80/~test1/file?action=view",
            "ftp://0.0.0.0:80/~test1/file?action=edit&mode=up",
            "ftp://0.0.0.0:80/~test1/file",
            "ftp://0.0.0.0/test1?action=view",
            "ftp://0.0.0.0/test1?action=edit&mode=up",
            "ftp://0.0.0.0/test1",
            "ftp://0.0.0.0/t123?action=view",
            "ftp://0.0.0.0/t123?action=edit&mode=up",
            "ftp://0.0.0.0/t123",
            "ftp://0.0.0.0/$23?action=view",
            "ftp://0.0.0.0/$23?action=edit&mode=up",
            "ftp://0.0.0.0/$23",
            "ftp://0.0.0.0/test1/?action=view",
            "ftp://0.0.0.0/test1/?action=edit&mode=up",
            "ftp://0.0.0.0/test1/",
            "ftp://0.0.0.0?action=view",
            "ftp://0.0.0.0?action=edit&mode=up",
            "ftp://0.0.0.0",
            "ftp://0.0.0.0/test1/file?action=view",
            "ftp://0.0.0.0/test1/file?action=edit&mode=up",
            "ftp://0.0.0.0/test1/file",
            "ftp://0.0.0.0/~test1/file?action=view",
            "ftp://0.0.0.0/~test1/file?action=edit&mode=up",
            "ftp://0.0.0.0/~test1/file",
            "ftp://255.255.255.255:80/test1?action=view",
            "ftp://255.255.255.255:80/test1?action=edit&mode=up",
            "ftp://255.255.255.255:80/test1",
            "ftp://255.255.255.255:80/t123?action=view",
            "ftp://255.255.255.255:80/t123?action=edit&mode=up",
            "ftp://255.255.255.255:80/t123",
            "ftp://255.255.255.255:80/$23?action=view",
            "ftp://255.255.255.255:80/$23?action=edit&mode=up",
            "ftp://255.255.255.255:80/$23",
            "ftp://255.255.255.255:80/test1/?action=view",
            "ftp://255.255.255.255:80/test1/?action=edit&mode=up",
            "ftp://255.255.255.255:80/test1/",
            "ftp://255.255.255.255:80?action=view",
            "ftp://255.255.255.255:80?action=edit&mode=up",
            "ftp://255.255.255.255:80",
            "ftp://255.255.255.255:80/test1/file?action=view",
            "ftp://255.255.255.255:80/test1/file?action=edit&mode=up",
            "ftp://255.255.255.255:80/test1/file",
            "ftp://255.255.255.255:80/~test1/file?action=view",
            "ftp://255.255.255.255:80/~test1/file?action=edit&mode=up",
            "ftp://255.255.255.255:80/~test1/file",
            "ftp://255.255.255.255/test1?action=view",
            "ftp://255.255.255.255/test1?action=edit&mode=up",
            "ftp://255.255.255.255/test1",
            "ftp://255.255.255.255/t123?action=view",
            "ftp://255.255.255.255/t123?action=edit&mode=up",
            "ftp://255.255.255.255/t123",
            "ftp://255.255.255.255/$23?action=view",
            "ftp://255.255.255.255/$23?action=edit&mode=up",
            "ftp://255.255.255.255/$23",
            "ftp://255.255.255.255/test1/?action=view",
            "ftp://255.255.255.255/test1/?action=edit&mode=up",
            "ftp://255.255.255.255/test1/",
            "ftp://255.255.255.255?action=view",
            "ftp://255.255.255.255?action=edit&mode=up",
            "ftp://255.255.255.255",
            "ftp://255.255.255.255/test1/file?action=view",
            "ftp://255.255.255.255/test1/file?action=edit&mode=up",
            "ftp://255.255.255.255/test1/file",
            "ftp://255.255.255.255/~test1/file?action=view",
            "ftp://255.255.255.255/~test1/file?action=edit&mode=up",
            "ftp://255.255.255.255/~test1/file",
            "ftp://255.com:80/test1?action=view",
            "ftp://255.com:80/test1?action=edit&mode=up",
            "ftp://255.com:80/test1",
            "ftp://255.com:80/t123?action=view",
            "ftp://255.com:80/t123?action=edit&mode=up",
            "ftp://255.com:80/t123",
            "ftp://255.com:80/$23?action=view",
            "ftp://255.com:80/$23?action=edit&mode=up",
            "ftp://255.com:80/$23",
            "ftp://255.com:80/test1/?action=view",
            "ftp://255.com:80/test1/?action=edit&mode=up",
            "ftp://255.com:80/test1/",
            "ftp://255.com:80?action=view",
            "ftp://255.com:80?action=edit&mode=up",
            "ftp://255.com:80",
            "ftp://255.com:80/test1/file?action=view",
            "ftp://255.com:80/test1/file?action=edit&mode=up",
            "ftp://255.com:80/test1/file",
            "ftp://255.com:80/~test1/file?action=view",
            "ftp://255.com:80/~test1/file?action=edit&mode=up",
            "ftp://255.com:80/~test1/file",
            "ftp://255.com/test1?action=view",
            "ftp://255.com/test1?action=edit&mode=up",
            "ftp://255.com/test1",
            "ftp://255.com/t123?action=view",
            "ftp://255.com/t123?action=edit&mode=up",
            "ftp://255.com/t123",
            "ftp://255.com/$23?action=view",
            "ftp://255.com/$23?action=edit&mode=up",
            "ftp://255.com/$23",
            "ftp://255.com/test1/?action=view",
            "ftp://255.com/test1/?action=edit&mode=up",
            "ftp://255.com/test1/",
            "ftp://255.com?action=view",
            "ftp://255.com?action=edit&mode=up",
            "ftp://255.com",
            "ftp://255.com/test1/file?action=view",
            "ftp://255.com/test1/file?action=edit&mode=up",
            "ftp://255.com/test1/file",
            "ftp://255.com/~test1/file?action=view",
            "ftp://255.com/~test1/file?action=edit&mode=up",
            "ftp://255.com/~test1/file",
            "h3t://www.google.com:80/test1?action=view",
            "h3t://www.google.com:80/test1?action=edit&mode=up",
            "h3t://www.google.com:80/test1",
            "h3t://www.google.com:80/t123?action=view",
            "h3t://www.google.com:80/t123?action=edit&mode=up",
            "h3t://www.google.com:80/t123",
            "h3t://www.google.com:80/$23?action=view",
            "h3t://www.google.com:80/$23?action=edit&mode=up",
            "h3t://www.google.com:80/$23",
            "h3t://www.google.com:80/test1/?action=view",
            "h3t://www.google.com:80/test1/?action=edit&mode=up",
            "h3t://www.google.com:80/test1/",
            "h3t://www.google.com:80?action=view",
            "h3t://www.google.com:80?action=edit&mode=up",
            "h3t://www.google.com:80",
            "h3t://www.google.com:80/test1/file?action=view",
            "h3t://www.google.com:80/test1/file?action=edit&mode=up",
            "h3t://www.google.com:80/test1/file",
            "h3t://www.google.com:80/~test1/file?action=view",
            "h3t://www.google.com:80/~test1/file?action=edit&mode=up",
            "h3t://www.google.com:80/~test1/file",
            "h3t://www.google.com/test1?action=view",
            "h3t://www.google.com/test1?action=edit&mode=up",
            "h3t://www.google.com/test1",
            "h3t://www.google.com/t123?action=view",
            "h3t://www.google.com/t123?action=edit&mode=up",
            "h3t://www.google.com/t123",
            "h3t://www.google.com/$23?action=view",
            "h3t://www.google.com/$23?action=edit&mode=up",
            "h3t://www.google.com/$23",
            "h3t://www.google.com/test1/?action=view",
            "h3t://www.google.com/test1/?action=edit&mode=up",
            "h3t://www.google.com/test1/",
            "h3t://www.google.com?action=view",
            "h3t://www.google.com?action=edit&mode=up",
            "h3t://www.google.com",
            "h3t://www.google.com/test1/file?action=view",
            "h3t://www.google.com/test1/file?action=edit&mode=up",
            "h3t://www.google.com/test1/file",
            "h3t://www.google.com/~test1/file?action=view",
            "h3t://www.google.com/~test1/file?action=edit&mode=up",
            "h3t://www.google.com/~test1/file",
            "h3t://go.com:80/test1?action=view",
            "h3t://go.com:80/test1?action=edit&mode=up",
            "h3t://go.com:80/test1",
            "h3t://go.com:80/t123?action=view",
            "h3t://go.com:80/t123?action=edit&mode=up",
            "h3t://go.com:80/t123",
            "h3t://go.com:80/$23?action=view",
            "h3t://go.com:80/$23?action=edit&mode=up",
            "h3t://go.com:80/$23",
            "h3t://go.com:80/test1/?action=view",
            "h3t://go.com:80/test1/?action=edit&mode=up",
            "h3t://go.com:80/test1/",
            "h3t://go.com:80?action=view",
            "h3t://go.com:80?action=edit&mode=up",
            "h3t://go.com:80",
            "h3t://go.com:80/test1/file?action=view",
            "h3t://go.com:80/test1/file?action=edit&mode=up",
            "h3t://go.com:80/test1/file",
            "h3t://go.com:80/~test1/file?action=view",
            "h3t://go.com:80/~test1/file?action=edit&mode=up",
            "h3t://go.com:80/~test1/file",
            "h3t://go.com/test1?action=view",
            "h3t://go.com/test1?action=edit&mode=up",
            "h3t://go.com/test1",
            "h3t://go.com/t123?action=view",
            "h3t://go.com/t123?action=edit&mode=up",
            "h3t://go.com/t123",
            "h3t://go.com/$23?action=view",
            "h3t://go.com/$23?action=edit&mode=up",
            "h3t://go.com/$23",
            "h3t://go.com/test1/?action=view",
            "h3t://go.com/test1/?action=edit&mode=up",
            "h3t://go.com/test1/",
            "h3t://go.com?action=view",
            "h3t://go.com?action=edit&mode=up",
            "h3t://go.com",
            "h3t://go.com/test1/file?action=view",
            "h3t://go.com/test1/file?action=edit&mode=up",
            "h3t://go.com/test1/file",
            "h3t://go.com/~test1/file?action=view",
            "h3t://go.com/~test1/file?action=edit&mode=up",
            "h3t://go.com/~test1/file",
            "h3t://go.au:80/test1?action=view",
            "h3t://go.au:80/test1?action=edit&mode=up",
            "h3t://go.au:80/test1",
            "h3t://go.au:80/t123?action=view",
            "h3t://go.au:80/t123?action=edit&mode=up",
            "h3t://go.au:80/t123",
            "h3t://go.au:80/$23?action=view",
            "h3t://go.au:80/$23?action=edit&mode=up",
            "h3t://go.au:80/$23",
            "h3t://go.au:80/test1/?action=view",
            "h3t://go.au:80/test1/?action=edit&mode=up",
            "h3t://go.au:80/test1/",
            "h3t://go.au:80?action=view",
            "h3t://go.au:80?action=edit&mode=up",
            "h3t://go.au:80",
            "h3t://go.au:80/test1/file?action=view",
            "h3t://go.au:80/test1/file?action=edit&mode=up",
            "h3t://go.au:80/test1/file",
            "h3t://go.au:80/~test1/file?action=view",
            "h3t://go.au:80/~test1/file?action=edit&mode=up",
            "h3t://go.au:80/~test1/file",
            "h3t://go.au/test1?action=view",
            "h3t://go.au/test1?action=edit&mode=up",
            "h3t://go.au/test1",
            "h3t://go.au/t123?action=view",
            "h3t://go.au/t123?action=edit&mode=up",
            "h3t://go.au/t123",
            "h3t://go.au/$23?action=view",
            "h3t://go.au/$23?action=edit&mode=up",
            "h3t://go.au/$23",
            "h3t://go.au/test1/?action=view",
            "h3t://go.au/test1/?action=edit&mode=up",
            "h3t://go.au/test1/",
            "h3t://go.au?action=view",
            "h3t://go.au?action=edit&mode=up",
            "h3t://go.au",
            "h3t://go.au/test1/file?action=view",
            "h3t://go.au/test1/file?action=edit&mode=up",
            "h3t://go.au/test1/file",
            "h3t://go.au/~test1/file?action=view",
            "h3t://go.au/~test1/file?action=edit&mode=up",
            "h3t://go.au/~test1/file",
            "h3t://0.0.0.0:80/test1?action=view",
            "h3t://0.0.0.0:80/test1?action=edit&mode=up",
            "h3t://0.0.0.0:80/test1",
            "h3t://0.0.0.0:80/t123?action=view",
            "h3t://0.0.0.0:80/t123?action=edit&mode=up",
            "h3t://0.0.0.0:80/t123",
            "h3t://0.0.0.0:80/$23?action=view",
            "h3t://0.0.0.0:80/$23?action=edit&mode=up",
            "h3t://0.0.0.0:80/$23",
            "h3t://0.0.0.0:80/test1/?action=view",
            "h3t://0.0.0.0:80/test1/?action=edit&mode=up",
            "h3t://0.0.0.0:80/test1/",
            "h3t://0.0.0.0:80?action=view",
            "h3t://0.0.0.0:80?action=edit&mode=up",
            "h3t://0.0.0.0:80",
            "h3t://0.0.0.0:80/test1/file?action=view",
            "h3t://0.0.0.0:80/test1/file?action=edit&mode=up",
            "h3t://0.0.0.0:80/test1/file",
            "h3t://0.0.0.0:80/~test1/file?action=view",
            "h3t://0.0.0.0:80/~test1/file?action=edit&mode=up",
            "h3t://0.0.0.0:80/~test1/file",
            "h3t://0.0.0.0/test1?action=view",
            "h3t://0.0.0.0/test1?action=edit&mode=up",
            "h3t://0.0.0.0/test1",
            "h3t://0.0.0.0/t123?action=view",
            "h3t://0.0.0.0/t123?action=edit&mode=up",
            "h3t://0.0.0.0/t123",
            "h3t://0.0.0.0/$23?action=view",
            "h3t://0.0.0.0/$23?action=edit&mode=up",
            "h3t://0.0.0.0/$23",
            "h3t://0.0.0.0/test1/?action=view",
            "h3t://0.0.0.0/test1/?action=edit&mode=up",
            "h3t://0.0.0.0/test1/",
            "h3t://0.0.0.0?action=view",
            "h3t://0.0.0.0?action=edit&mode=up",
            "h3t://0.0.0.0",
            "h3t://0.0.0.0/test1/file?action=view",
            "h3t://0.0.0.0/test1/file?action=edit&mode=up",
            "h3t://0.0.0.0/test1/file",
            "h3t://0.0.0.0/~test1/file?action=view",
            "h3t://0.0.0.0/~test1/file?action=edit&mode=up",
            "h3t://0.0.0.0/~test1/file",
            "h3t://255.255.255.255:80/test1?action=view",
            "h3t://255.255.255.255:80/test1?action=edit&mode=up",
            "h3t://255.255.255.255:80/test1",
            "h3t://255.255.255.255:80/t123?action=view",
            "h3t://255.255.255.255:80/t123?action=edit&mode=up",
            "h3t://255.255.255.255:80/t123",
            "h3t://255.255.255.255:80/$23?action=view",
            "h3t://255.255.255.255:80/$23?action=edit&mode=up",
            "h3t://255.255.255.255:80/$23",
            "h3t://255.255.255.255:80/test1/?action=view",
            "h3t://255.255.255.255:80/test1/?action=edit&mode=up",
            "h3t://255.255.255.255:80/test1/",
            "h3t://255.255.255.255:80?action=view",
            "h3t://255.255.255.255:80?action=edit&mode=up",
            "h3t://255.255.255.255:80",
            "h3t://255.255.255.255:80/test1/file?action=view",
            "h3t://255.255.255.255:80/test1/file?action=edit&mode=up",
            "h3t://255.255.255.255:80/test1/file",
            "h3t://255.255.255.255:80/~test1/file?action=view",
            "h3t://255.255.255.255:80/~test1/file?action=edit&mode=up",
            "h3t://255.255.255.255:80/~test1/file",
            "h3t://255.255.255.255/test1?action=view",
            "h3t://255.255.255.255/test1?action=edit&mode=up",
            "h3t://255.255.255.255/test1",
            "h3t://255.255.255.255/t123?action=view",
            "h3t://255.255.255.255/t123?action=edit&mode=up",
            "h3t://255.255.255.255/t123",
            "h3t://255.255.255.255/$23?action=view",
            "h3t://255.255.255.255/$23?action=edit&mode=up",
            "h3t://255.255.255.255/$23",
            "h3t://255.255.255.255/test1/?action=view",
            "h3t://255.255.255.255/test1/?action=edit&mode=up",
            "h3t://255.255.255.255/test1/",
            "h3t://255.255.255.255?action=view",
            "h3t://255.255.255.255?action=edit&mode=up",
            "h3t://255.255.255.255",
            "h3t://255.255.255.255/test1/file?action=view",
            "h3t://255.255.255.255/test1/file?action=edit&mode=up",
            "h3t://255.255.255.255/test1/file",
            "h3t://255.255.255.255/~test1/file?action=view",
            "h3t://255.255.255.255/~test1/file?action=edit&mode=up",
            "h3t://255.255.255.255/~test1/file",
            "h3t://255.com:80/test1?action=view",
            "h3t://255.com:80/test1?action=edit&mode=up",
            "h3t://255.com:80/test1",
            "h3t://255.com:80/t123?action=view",
            "h3t://255.com:80/t123?action=edit&mode=up",
            "h3t://255.com:80/t123",
            "h3t://255.com:80/$23?action=view",
            "h3t://255.com:80/$23?action=edit&mode=up",
            "h3t://255.com:80/$23",
            "h3t://255.com:80/test1/?action=view",
            "h3t://255.com:80/test1/?action=edit&mode=up",
            "h3t://255.com:80/test1/",
            "h3t://255.com:80?action=view",
            "h3t://255.com:80?action=edit&mode=up",
            "h3t://255.com:80",
            "h3t://255.com:80/test1/file?action=view",
            "h3t://255.com:80/test1/file?action=edit&mode=up",
            "h3t://255.com:80/test1/file",
            "h3t://255.com:80/~test1/file?action=view",
            "h3t://255.com:80/~test1/file?action=edit&mode=up",
            "h3t://255.com:80/~test1/file",
            "h3t://255.com/test1?action=view",
            "h3t://255.com/test1?action=edit&mode=up",
            "h3t://255.com/test1",
            "h3t://255.com/t123?action=view",
            "h3t://255.com/t123?action=edit&mode=up",
            "h3t://255.com/t123",
            "h3t://255.com/$23?action=view",
            "h3t://255.com/$23?action=edit&mode=up",
            "h3t://255.com/$23",
            "h3t://255.com/test1/?action=view",
            "h3t://255.com/test1/?action=edit&mode=up",
            "h3t://255.com/test1/",
            "h3t://255.com?action=view",
            "h3t://255.com?action=edit&mode=up",
            "h3t://255.com",
            "h3t://255.com/test1/file?action=view",
            "h3t://255.com/test1/file?action=edit&mode=up",
            "h3t://255.com/~test1/file?action=view",
            "h3t://255.com/~test1/file?action=edit&mode=up",
            "h3t://255.com/~test1/file",
            "h3t://255.com/test1/file"


    };





   String [] right_url ={"http://www.google.com:80/test1?action=view",
            "http://www.google.com:80/test1?action=edit&mode=up",
            "http://www.google.com:80/test1",
            "http://www.google.com:80/t123?action=view",
            "http://www.google.com:80/t123?action=edit&mode=up",
            "http://www.google.com:80/t123",
            "http://www.google.com:80/$23?action=view",
            "http://www.google.com:80/$23?action=edit&mode=up",
            "http://www.google.com:80/$23",
            "http://www.google.com:80/test1/?action=view",
            "http://www.google.com:80/test1/?action=edit&mode=up",
            "http://www.google.com:80/test1/",
            "http://www.google.com:80?action=view",
            "http://www.google.com:80?action=edit&mode=up",
            "http://www.google.com:80",
            "http://www.google.com:80/test1/file?action=view",
            "http://www.google.com:80/test1/file?action=edit&mode=up",
            "http://www.google.com:80/test1/file",
            "http://www.google.com:80/~test1/file?action=view",
            "http://www.google.com:80/~test1/file?action=edit&mode=up",
            "http://www.google.com:80/~test1/file",
            "http://www.google.com/test1?action=view",
            "http://www.google.com/test1?action=edit&mode=up",
            "http://www.google.com/test1",
            "http://www.google.com/t123?action=view",
            "http://www.google.com/t123?action=edit&mode=up",
            "http://www.google.com/t123",
            "http://www.google.com/$23?action=view",
            "http://www.google.com/$23?action=edit&mode=up",
            "http://www.google.com/$23",
            "http://www.google.com/test1/?action=view",
            "http://www.google.com/test1/?action=edit&mode=up",
            "http://www.google.com/test1/",
            "http://www.google.com?action=view",
            "http://www.google.com?action=edit&mode=up",
            "http://www.google.com",
            "http://www.google.com/test1/file?action=view",
            "http://www.google.com/test1/file?action=edit&mode=up",
            "http://www.google.com/test1/file",
            "http://www.google.com/~test1/file?action=view",
            "http://www.google.com/~test1/file?action=edit&mode=up",
            "http://www.google.com/~test1/file",
            "http://go.com:80/test1?action=view",
            "http://go.com:80/test1?action=edit&mode=up",
            "http://go.com:80/test1",
            "http://go.com:80/t123?action=view",
            "http://go.com:80/t123?action=edit&mode=up",
            "http://go.com:80/t123",
            "http://go.com:80/$23?action=view",
            "http://go.com:80/$23?action=edit&mode=up",
            "http://go.com:80/$23",
            "http://go.com:80/test1/?action=view",
            "http://go.com:80/test1/?action=edit&mode=up",
            "http://go.com:80/test1/",
            "http://go.com:80?action=view",
            "http://go.com:80?action=edit&mode=up",
            "http://go.com:80",
            "http://go.com:80/test1/file?action=view",
            "http://go.com:80/test1/file?action=edit&mode=up",
            "http://go.com:80/test1/file",
            "http://go.com:80/~test1/file?action=view",
            "http://go.com:80/~test1/file?action=edit&mode=up",
            "http://go.com:80/~test1/file",
            "http://go.com/test1?action=view",
            "http://go.com/test1?action=edit&mode=up",
            "http://go.com/test1",
            "http://go.com/t123?action=view",
            "http://go.com/t123?action=edit&mode=up",
            "http://go.com/t123",
            "http://go.com/$23?action=view",
            "http://go.com/$23?action=edit&mode=up",
            "http://go.com/$23",
            "http://go.com/test1/?action=view",
            "http://go.com/test1/?action=edit&mode=up",
            "http://go.com/test1/",
            "http://go.com?action=view",
            "http://go.com?action=edit&mode=up",
            "http://go.com",
            "http://go.com/test1/file?action=view",
            "http://go.com/test1/file?action=edit&mode=up",
            "http://go.com/test1/file",
            "http://go.com/~test1/file?action=view",
            "http://go.com/~test1/file?action=edit&mode=up",
            "http://go.com/~test1/file",
            "http://go.au:80/test1?action=view",
            "http://go.au:80/test1?action=edit&mode=up",
            "http://go.au:80/test1",
            "http://go.au:80/t123?action=view",
            "http://go.au:80/t123?action=edit&mode=up",
            "http://go.au:80/t123",
            "http://go.au:80/$23?action=view",
            "http://go.au:80/$23?action=edit&mode=up",
            "http://go.au:80/$23",
            "http://go.au:80/test1/?action=view",
            "http://go.au:80/test1/?action=edit&mode=up",
            "http://go.au:80/test1/",
            "http://go.au:80?action=view",
            "http://go.au:80?action=edit&mode=up",
            "http://go.au:80",
            "http://go.au:80/test1/file?action=view",
            "http://go.au:80/test1/file?action=edit&mode=up",
            "http://go.au:80/test1/file",
            "http://go.au:80/~test1/file?action=view",
            "http://go.au:80/~test1/file?action=edit&mode=up",
            "http://go.au:80/~test1/file",
            "http://go.au/test1?action=view",
            "http://go.au/test1?action=edit&mode=up",
            "http://go.au/test1",
            "http://go.au/t123?action=view",
            "http://go.au/t123?action=edit&mode=up",
            "http://go.au/t123",
            "http://go.au/$23?action=view",
            "http://go.au/$23?action=edit&mode=up",
            "http://go.au/$23",
            "http://go.au/test1/?action=view",
            "http://go.au/test1/?action=edit&mode=up",
            "http://go.au/test1/",
            "http://go.au?action=view",
            "http://go.au?action=edit&mode=up",
            "http://go.au",
            "http://go.au/test1/file?action=view",
            "http://go.au/test1/file?action=edit&mode=up",
           "http://go.au/~test1/file?action=view",
            "http://go.au/~test1/file?action=edit&mode=up",
            "http://go.au/~test1/file",
           "http://go.au/test1/file"

};







String [] right_ftp={
        "ftp://www.google.com/test1?action=view",
        "ftp://www.google.com/test1?action=edit&mode=up",
        "ftp://www.google.com/test1",
        "ftp://www.google.com/t123?action=view",
        "ftp://www.google.com/t123?action=edit&mode=up",
        "ftp://www.google.com/t123",
        "ftp://www.google.com/$23?action=view",
        "ftp://www.google.com/$23?action=edit&mode=up",
        "ftp://www.google.com/$23",
        "ftp://www.google.com/test1/?action=view",
        "ftp://www.google.com/test1/?action=edit&mode=up",
        "ftp://www.google.com/test1/",
        "ftp://www.google.com?action=view",
        "ftp://www.google.com?action=edit&mode=up",
        "ftp://www.google.com",
        "ftp://www.google.com/test1/file?action=view",
        "ftp://www.google.com/test1/file?action=edit&mode=up",
        "ftp://www.google.com/test1/file",
        "ftp://go.com/test1?action=view",
        "ftp://go.com/test1?action=edit&mode=up",
        "ftp://go.com/test1",
        "ftp://go.com/t123?action=view",
        "ftp://go.com/t123?action=edit&mode=up",
        "ftp://go.com/t123",
        "ftp://go.com/$23?action=view",
        "ftp://go.com/$23?action=edit&mode=up",
        "ftp://go.com/$23",
        "ftp://go.com/test1/?action=view",
        "ftp://go.com/test1/?action=edit&mode=up",
        "ftp://go.com/test1/",
        "ftp://go.com?action=view",
        "ftp://go.com?action=edit&mode=up",
        "ftp://go.com",
        "ftp://go.com/test1/file?action=view",
        "ftp://go.com/test1/file?action=edit&mode=up",
        "ftp://go.com/test1/file",
        "ftp://go.au/test1?action=view",
        "ftp://go.au/test1?action=edit&mode=up",
        "ftp://go.au/test1",
        "ftp://go.au/t123?action=view",
        "ftp://go.au/t123?action=edit&mode=up",
        "ftp://go.au/t123",
        "ftp://go.au/$23?action=view",
        "ftp://go.au/$23?action=edit&mode=up",
        "ftp://go.au/$23",
        "ftp://go.au/test1/?action=view",
        "ftp://go.au/test1/?action=edit&mode=up",
        "ftp://go.au/test1/",
        "ftp://go.au?action=view",
        "ftp://go.au?action=edit&mode=up",
        "ftp://go.au",
        "ftp://go.au/test1/file?action=view",
        "ftp://go.au/test1/file?action=edit&mode=up",
        "ftp://go.au/test1/file"



};


String [] right_h3t={
        "h3t://www.google.com:80/test1?action=view",
        "h3t://www.google.com:80/test1?action=edit&mode=up",
        "h3t://www.google.com:80/test1",
        "h3t://www.google.com:80/t123?action=view",
        "h3t://www.google.com:80/t123?action=edit&mode=up",
        "h3t://www.google.com:80/t123",
        "h3t://www.google.com:80/$23?action=view",
        "h3t://www.google.com:80/$23?action=edit&mode=up",
        "h3t://www.google.com:80/$23",
        "h3t://www.google.com:80/test1/?action=view",
        "h3t://www.google.com:80/test1/?action=edit&mode=up",
        "h3t://www.google.com:80/test1/",
        "h3t://www.google.com:80?action=view",
        "h3t://www.google.com:80?action=edit&mode=up",
        "h3t://www.google.com:80",
        "h3t://www.google.com:80/test1/file?action=view",
        "h3t://www.google.com:80/test1/file?action=edit&mode=up",
        "h3t://www.google.com:80/test1/file",
        "h3t://www.google.com:80/~test1/file?action=view",
        "h3t://www.google.com:80/~test1/file?action=edit&mode=up",
        "h3t://www.google.com:80/~test1/file",
        "h3t://www.google.com/test1?action=view",
        "h3t://www.google.com/test1?action=edit&mode=up",
        "h3t://www.google.com/test1",
        "h3t://www.google.com/t123?action=view",
        "h3t://www.google.com/t123?action=edit&mode=up",
        "h3t://www.google.com/t123",
        "h3t://www.google.com/$23?action=view",
        "h3t://www.google.com/$23?action=edit&mode=up",
        "h3t://www.google.com/$23",
        "h3t://www.google.com/test1/?action=view",
        "h3t://www.google.com/test1/?action=edit&mode=up",
        "h3t://www.google.com/test1/",
        "h3t://www.google.com?action=view",
        "h3t://www.google.com?action=edit&mode=up",
        "h3t://www.google.com",
        "h3t://www.google.com/test1/file?action=view",
        "h3t://www.google.com/test1/file?action=edit&mode=up",
        "h3t://www.google.com/test1/file",
        "h3t://www.google.com/~test1/file?action=view",
        "h3t://www.google.com/~test1/file?action=edit&mode=up",
        "h3t://www.google.com/~test1/file",
        "h3t://go.com:80/test1?action=view",
        "h3t://go.com:80/test1?action=edit&mode=up",
        "h3t://go.com:80/test1",
        "h3t://go.com:80/t123?action=view",
        "h3t://go.com:80/t123?action=edit&mode=up",
        "h3t://go.com:80/t123",
        "h3t://go.com:80/$23?action=view",
        "h3t://go.com:80/$23?action=edit&mode=up",
        "h3t://go.com:80/$23",
        "h3t://go.com:80/test1/?action=view",
        "h3t://go.com:80/test1/?action=edit&mode=up",
        "h3t://go.com:80/test1/",
        "h3t://go.com:80?action=view",
        "h3t://go.com:80?action=edit&mode=up",
        "h3t://go.com:80",
        "h3t://go.com:80/test1/file?action=view",
        "h3t://go.com:80/test1/file?action=edit&mode=up",
        "h3t://go.com:80/test1/file",
        "h3t://go.com:80/~test1/file?action=view",
        "h3t://go.com:80/~test1/file?action=edit&mode=up",
        "h3t://go.com:80/~test1/file",
        "h3t://go.com/test1?action=view",
        "h3t://go.com/test1?action=edit&mode=up",
        "h3t://go.com/test1",
        "h3t://go.com/t123?action=view",
        "h3t://go.com/t123?action=edit&mode=up",
        "h3t://go.com/t123",
        "h3t://go.com/$23?action=view",
        "h3t://go.com/$23?action=edit&mode=up",
        "h3t://go.com/$23",
        "h3t://go.com/test1/?action=view",
        "h3t://go.com/test1/?action=edit&mode=up",
        "h3t://go.com/test1/",
        "h3t://go.com?action=view",
        "h3t://go.com?action=edit&mode=up",
        "h3t://go.com",
        "h3t://go.com/test1/file?action=view",
        "h3t://go.com/test1/file?action=edit&mode=up",
        "h3t://go.com/test1/file",
        "h3t://go.com/~test1/file?action=view",
        "h3t://go.com/~test1/file?action=edit&mode=up",
        "h3t://go.com/~test1/file",
        "h3t://go.au:80/test1?action=view",
        "h3t://go.au:80/test1?action=edit&mode=up",
        "h3t://go.au:80/test1",
        "h3t://go.au:80/t123?action=view",
        "h3t://go.au:80/t123?action=edit&mode=up",
        "h3t://go.au:80/t123",
        "h3t://go.au:80/$23?action=view",
        "h3t://go.au:80/$23?action=edit&mode=up",
        "h3t://go.au:80/$23",
        "h3t://go.au:80/test1/?action=view",
        "h3t://go.au:80/test1/?action=edit&mode=up",
        "h3t://go.au:80/test1/",
        "h3t://go.au:80?action=view",
        "h3t://go.au:80?action=edit&mode=up",
        "h3t://go.au:80",
        "h3t://go.au:80/test1/file?action=view",
        "h3t://go.au:80/test1/file?action=edit&mode=up",
        "h3t://go.au:80/test1/file",
        "h3t://go.au:80/~test1/file?action=view",
        "h3t://go.au:80/~test1/file?action=edit&mode=up",
        "h3t://go.au:80/~test1/file",
        "h3t://go.au/test1?action=view",
        "h3t://go.au/test1?action=edit&mode=up",
        "h3t://go.au/test1",
        "h3t://go.au/t123?action=view",
        "h3t://go.au/t123?action=edit&mode=up",
        "h3t://go.au/t123",
        "h3t://go.au/$23?action=view",
        "h3t://go.au/$23?action=edit&mode=up",
        "h3t://go.au/$23",
        "h3t://go.au/test1/?action=view",
        "h3t://go.au/test1/?action=edit&mode=up",
        "h3t://go.au/test1/",
        "h3t://go.au?action=view",
        "h3t://go.au?action=edit&mode=up",
        "h3t://go.au",
        "h3t://go.au/test1/file?action=view",
        "h3t://go.au/test1/file?action=edit&mode=up",
        "h3t://go.au/test1/file",
        "h3t://go.au/~test1/file?action=view",
        "h3t://go.au/~test1/file?action=edit&mode=up",
        "h3t://go.au/~test1/file",
        "h3t://0.0.0.0:80/test1?action=view",
        "h3t://0.0.0.0:80/test1?action=edit&mode=up",
        "h3t://0.0.0.0:80/test1",
        "h3t://0.0.0.0:80/t123?action=view",
        "h3t://0.0.0.0:80/t123?action=edit&mode=up",
        "h3t://0.0.0.0:80/t123",
        "h3t://0.0.0.0:80/$23?action=view",
        "h3t://0.0.0.0:80/$23?action=edit&mode=up",
        "h3t://0.0.0.0:80/$23",
        "h3t://0.0.0.0:80/test1/?action=view",
        "h3t://0.0.0.0:80/test1/?action=edit&mode=up",
        "h3t://0.0.0.0:80/test1/",
        "h3t://0.0.0.0:80?action=view",
        "h3t://0.0.0.0:80?action=edit&mode=up",
        "h3t://0.0.0.0:80",
        "h3t://0.0.0.0:80/test1/file?action=view",
        "h3t://0.0.0.0:80/test1/file?action=edit&mode=up",
        "h3t://0.0.0.0:80/test1/file",
        "h3t://0.0.0.0:80/~test1/file?action=view",
        "h3t://0.0.0.0:80/~test1/file?action=edit&mode=up",
        "h3t://0.0.0.0:80/~test1/file",
        "h3t://0.0.0.0/test1?action=view",
        "h3t://0.0.0.0/test1?action=edit&mode=up",
        "h3t://0.0.0.0/test1",
        "h3t://0.0.0.0/t123?action=view",
        "h3t://0.0.0.0/t123?action=edit&mode=up",
        "h3t://0.0.0.0/t123",
        "h3t://0.0.0.0/$23?action=view",
        "h3t://0.0.0.0/$23?action=edit&mode=up",
        "h3t://0.0.0.0/$23",
        "h3t://0.0.0.0/test1/?action=view",
        "h3t://0.0.0.0/test1/?action=edit&mode=up",
        "h3t://0.0.0.0/test1/",
        "h3t://0.0.0.0?action=view",
        "h3t://0.0.0.0?action=edit&mode=up",
        "h3t://0.0.0.0",
        "h3t://0.0.0.0/test1/file?action=view",
        "h3t://0.0.0.0/test1/file?action=edit&mode=up",
        "h3t://0.0.0.0/test1/file",
        "h3t://0.0.0.0/~test1/file?action=view",
        "h3t://0.0.0.0/~test1/file?action=edit&mode=up",
        "h3t://0.0.0.0/~test1/file",
        "h3t://255.255.255.255:80/test1?action=view",
        "h3t://255.255.255.255:80/test1?action=edit&mode=up",
        "h3t://255.255.255.255:80/test1",
        "h3t://255.255.255.255:80/t123?action=view",
        "h3t://255.255.255.255:80/t123?action=edit&mode=up",
        "h3t://255.255.255.255:80/t123",
        "h3t://255.255.255.255:80/$23?action=view",
        "h3t://255.255.255.255:80/$23?action=edit&mode=up",
        "h3t://255.255.255.255:80/$23",
        "h3t://255.255.255.255:80/test1/?action=view",
        "h3t://255.255.255.255:80/test1/?action=edit&mode=up",
        "h3t://255.255.255.255:80/test1/",
        "h3t://255.255.255.255:80?action=view",
        "h3t://255.255.255.255:80?action=edit&mode=up",
        "h3t://255.255.255.255:80",
        "h3t://255.255.255.255:80/test1/file?action=view",
        "h3t://255.255.255.255:80/test1/file?action=edit&mode=up",
        "h3t://255.255.255.255:80/test1/file",
        "h3t://255.255.255.255:80/~test1/file?action=view",
        "h3t://255.255.255.255:80/~test1/file?action=edit&mode=up",
        "h3t://255.255.255.255:80/~test1/file",
        "h3t://255.255.255.255/test1?action=view",
        "h3t://255.255.255.255/test1?action=edit&mode=up",
        "h3t://255.255.255.255/test1",
        "h3t://255.255.255.255/t123?action=view",
        "h3t://255.255.255.255/t123?action=edit&mode=up",
        "h3t://255.255.255.255/t123",
        "h3t://255.255.255.255/$23?action=view",
        "h3t://255.255.255.255/$23?action=edit&mode=up",
        "h3t://255.255.255.255/$23",
        "h3t://255.255.255.255/test1/?action=view",
        "h3t://255.255.255.255/test1/?action=edit&mode=up",
        "h3t://255.255.255.255/test1/",
        "h3t://255.255.255.255?action=view",
        "h3t://255.255.255.255?action=edit&mode=up",
        "h3t://255.255.255.255",
        "h3t://255.255.255.255/test1/file?action=view",
        "h3t://255.255.255.255/test1/file?action=edit&mode=up",
        "h3t://255.255.255.255/test1/file",
        "h3t://255.255.255.255/~test1/file?action=view",
        "h3t://255.255.255.255/~test1/file?action=edit&mode=up",
        "h3t://255.255.255.255/~test1/file",
        "h3t://255.com:80/test1?action=view",
        "h3t://255.com:80/test1?action=edit&mode=up",
        "h3t://255.com:80/test1",
        "h3t://255.com:80/t123?action=view",
        "h3t://255.com:80/t123?action=edit&mode=up",
        "h3t://255.com:80/t123",
        "h3t://255.com:80/$23?action=view",
        "h3t://255.com:80/$23?action=edit&mode=up",
        "h3t://255.com:80/$23",
        "h3t://255.com:80/test1/?action=view",
        "h3t://255.com:80/test1/?action=edit&mode=up",
        "h3t://255.com:80/test1/",
        "h3t://255.com:80?action=view",
        "h3t://255.com:80?action=edit&mode=up",
        "h3t://255.com:80",
        "h3t://255.com:80/test1/file?action=view",
        "h3t://255.com:80/test1/file?action=edit&mode=up",
        "h3t://255.com:80/test1/file",
        "h3t://255.com:80/~test1/file?action=view",
        "h3t://255.com:80/~test1/file?action=edit&mode=up",
        "h3t://255.com:80/~test1/file",
        "h3t://255.com/test1?action=view",
        "h3t://255.com/test1?action=edit&mode=up",
        "h3t://255.com/test1",
        "h3t://255.com/t123?action=view",
        "h3t://255.com/t123?action=edit&mode=up",
        "h3t://255.com/t123",
        "h3t://255.com/$23?action=view",
        "h3t://255.com/$23?action=edit&mode=up",
        "h3t://255.com/$23",
        "h3t://255.com/test1/?action=view",
        "h3t://255.com/test1/?action=edit&mode=up",
        "h3t://255.com/test1/",
        "h3t://255.com?action=view",
        "h3t://255.com?action=edit&mode=up",
        "h3t://255.com",
        "h3t://255.com/test1/file?action=view",
        "h3t://255.com/test1/file?action=edit&mode=up",
        "h3t://255.com/~test1/file?action=view",
        "h3t://255.com/~test1/file?action=edit&mode=up",
        "h3t://255.com/~test1/file",
        "h3t://255.com/test1/file"


};


String [] http_url_with_port ={"http://www.google.com:80/test1?action=view",
        "http://www.google.com:80/test1?action=edit&mode=up",
        "http://www.google.com:80/test1",
        "http://www.google.com:80/t123?action=view",
        "http://www.google.com:80/t123?action=edit&mode=up",
        "http://www.google.com:80/t123",
        "http://www.google.com:80/$23?action=view",
        "http://www.google.com:80/$23?action=edit&mode=up",
        "http://www.google.com:80/$23",
        "http://www.google.com:80/test1/?action=view",
        "http://www.google.com:80/test1/?action=edit&mode=up",
        "http://www.google.com:80/test1/",
        "http://www.google.com:80?action=view",
        "http://www.google.com:80?action=edit&mode=up",
        "http://www.google.com:80",
        "http://www.google.com:80/test1/file?action=view",
        "http://www.google.com:80/test1/file?action=edit&mode=up",
        "http://www.google.com:80/test1/file",
        "http://www.google.com:80/~test1/file?action=view",
        "http://www.google.com:80/~test1/file?action=edit&mode=up",
        "http://www.google.com:80/~test1/file",
        "http://go.com:80/test1?action=view",
        "http://go.com:80/test1?action=edit&mode=up",
        "http://go.com:80/test1",
        "http://go.com:80/t123?action=view",
        "http://go.com:80/t123?action=edit&mode=up",
        "http://go.com:80/t123",
        "http://go.com:80/$23?action=view",
        "http://go.com:80/$23?action=edit&mode=up",
        "http://go.com:80/$23",
        "http://go.com:80/test1/?action=view",
        "http://go.com:80/test1/?action=edit&mode=up",
        "http://go.com:80/test1/",
        "http://go.com:80?action=view",
        "http://go.com:80?action=edit&mode=up",
        "http://go.com:80",
        "http://go.com:80/test1/file?action=view",
        "http://go.com:80/test1/file?action=edit&mode=up",
        "http://go.com:80/test1/file",
        "http://go.com:80/~test1/file?action=view",
        "http://go.com:80/~test1/file?action=edit&mode=up",
        "http://go.com:80/~test1/file",
        "http://go.au:80/test1?action=view",
        "http://go.au:80/test1?action=edit&mode=up",
        "http://go.au:80/test1",
        "http://go.au:80/t123?action=view",
        "http://go.au:80/t123?action=edit&mode=up",
        "http://go.au:80/t123",
        "http://go.au:80/$23?action=view",
        "http://go.au:80/$23?action=edit&mode=up",
        "http://go.au:80/$23",
        "http://go.au:80/test1/?action=view",
        "http://go.au:80/test1/?action=edit&mode=up",
        "http://go.au:80/test1/",
        "http://go.au:80?action=view",
        "http://go.au:80?action=edit&mode=up",
        "http://go.au:80",
        "http://go.au:80/test1/file?action=view",
        "http://go.au:80/test1/file?action=edit&mode=up",
        "http://go.au:80/~test1/file?action=view",
        "http://go.au:80/~test1/file?action=edit&mode=up",
        "http://go.au:80/~test1/file",
        "http://go.au:80/test1/file"


};














}
