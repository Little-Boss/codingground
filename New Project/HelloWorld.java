
//alphabet for ciphering
String lowerCase = "abcdefghijklmnopqrstuvwxyz ,.?";
String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ,.?";

//Strings for key and message
String keyText = "Bai";
String messageText = "I love you";
String fixedKey = "";

//change to array
String[] key = new String[keyText.length()];
for( int i = 0; i < keyText.length(); i++ ){
    key[i] = keyText.substring(i, i + 1);
}
String[] message = new String[messageText.length()];
for( int i = 0; i < messageText.length(); i++ ){
    message[i] = messageText.substring(i, i + 1);
}

//make key as long as message
if( messageText.length() < keyText.length() ){
    keyText = keyText.substring(0, messageText.length());
}else{
    for( int i = 0; i < ( messageText.length() / keyText.length() ); i++ ){
        fixedKey += keyText;
    }
    fixedKey += fixedKey.substring(0, messageText.length() - fixedKey.length());
}


//change to all caps, and find invalid characters
for( int i = 0; i < keyText.length(); i++ ){
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

//make key as long as message


//change ABC's to array
String[] ABC = new String[upperCase.length()];
for( int i = 0; i < upperCase.length(); i++ ){
    ABC[i] = upperCase.substring(i, i + 1);
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
