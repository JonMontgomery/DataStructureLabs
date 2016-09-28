//-----------------------------------------------------------------------------
// HelloUser2.java
// Prints greeting to stdout, then prints out some environment information.
//-----------------------------------------------------------------------------
class HelloUser2{
   public static void main( String[] args ){
      String userName = System.getProperty("user.name");
      String os       = System.getProperty("os.name");
      String osVer    = System.getProperty("os.version");
      String jre      = System.getProperty("java.runtime.name");
      String jreVer   = System.getProperty("java.runtime.version");
      String jvm      = System.getProperty("java.vm.name");
      String jvmVer   = System.getProperty("java.vm.version");
      String javaHome = System.getProperty("java.home");
      long freemem    = Runtime.getRuntime().freeMemory();
      long time       = System.currentTimeMillis();

      System.out.println("Hello Jon!xD");
      
   }
}