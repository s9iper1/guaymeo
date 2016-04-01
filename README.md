Simple  but efficient library to stream radio in background
supported formats
pls
ram
wax

How to use

     RadioManager mRadioManager;

     mRadioManager = RadioManager.with(this);
 
initialize 

       mRadioManager.registerListener(this);
       mRadioManager.setLogging(true);
       mRadioManager.connect();
        
  than you call mRadioManager.startRadio("url");
  
  to stop Radio mRadioManager.stop
  
  special thanks to this guy https://github.com/iammert/RadioPlayerService
