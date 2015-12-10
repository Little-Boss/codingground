public class HelloWorld{

     public static void main(String []args){
//alphabet for ciphering
String lowerCase = "abcdefghijklmnopqrstuvwxyz ,.?";
String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ,.?";

//Strings for key and message
String keyText = "BIGmike";
String messageText = "Wanna be more than friends?";
String fixedKey = "";

//make key as long as message
if( messageText.length() < keyText.length() ){
    fixedKey = keyText.substring(0, messageText.length());
}else{
    for( int i = 0; i < ( messageText.length() / keyText.length() ); i++ ){
        fixedKey += keyText;
    }
    fixedKey += fixedKey.substring(0, messageText.length() - fixedKey.length());
}

//change to array
String[] key = new String[fixedKey.length()];
for( int i = 0; i < fixedKey.length(); i++ ){
    key[i] = fixedKey.substring(i, i + 1);
}
String[] message = new String[messageText.length()];
for( int i = 0; i < messageText.length(); i++ ){
    message[i] = messageText.substring(i, i + 1);
}

//change to all caps, and find invalid characters
for( int i = 0; i < fixedKey.length(); i++ ){
    if( lowerCase.indexOf(key[i]) >= 0 ){
        key[i] = upperCase.substring(lowerCase.indexOf(key[i]), lowerCase.indexOf(key[i]) + 1);
    }
    if( lowerCase.indexOf(key[i]) < 0 && upperCase.indexOf(key[i]) < 0 ){
        System.out.println( "Key contains " + "\"" + key[i] + "\"" + ", an invalid characer!" + "\nPlease stick to \"A-Z\", \" \"(space), \",\", \".\", and \"?\"\n" );
    }
}
for( int i = 0; i < messageText.length(); i++ ){
    if( lowerCase.indexOf(message[i]) >= 0 ){
        message[i] = upperCase.substring(lowerCase.indexOf(message[i]), lowerCase.indexOf(message[i]) + 1);
    }
    if( lowerCase.indexOf(message[i]) < 0 && upperCase.indexOf(message[i]) < 0 ){
        System.out.println( "Message contains " + "\"" + message[i] + "\"" + ", an invalid characer!" + "\nPlease stick to \"A-Z\", \" \"(space), \",\", \".\", and \"?\"\n" );
    }
}

//change ABC's to array
String[] ABC = new String[upperCase.length()];
for( int i = 0; i < upperCase.length(); i++ ){
    ABC[i] = upperCase.substring(i, i + 1);
}

//Cipher!!!
String crypticMessage = "";
for( int i = 0; i < fixedKey.length(); i++ ){
    if( upperCase.indexOf(message[i]) > upperCase.indexOf(key[i]) ){
        int position = upperCase.length() - (upperCase.indexOf(message[i]) - upperCase.indexOf(key[i]));
        crypticMessage += upperCase.substring( position, position + 1 );
    }
    if( upperCase.indexOf(message[i]) < upperCase.indexOf(key[i]) ){
        int position = upperCase.indexOf( upperCase.indexOf(key[i]) - upperCase.indexOf(message[i]) );
        upperCase.substring( position, position + 1 );
    }
}

/*
for( int i = 0; i < key.length(); i++ ){
for( int j = 0; j < upperCase.length(); j++ ){
if( key.substring(i, i + 1).equals(lowerCase[j]) ){
key.substring(i, i + 1) = upperCase[j];
} else{

}

}
}
*/
System.out.println(fixedKey);
     }
}
