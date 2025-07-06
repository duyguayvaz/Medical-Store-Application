package ce103_hw4_medical_store_lib;

import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.IntStream;

public class ConversionUtility 
{
	/**
	 * Converts a hexadecimal string to an array of bytes.
	 * @param hexString A string containing hexadecimal digits.
	 * @return An array of bytes representing the integer values of the hexadecimal digits in the input string.
	 */
	public static Byte[] toByte(String hexString) 
	{
	    return IntStream
	        .range(0, hexString.length())
	        .filter(x -> x % 2 == 0)
	        .map(x -> Integer.parseInt(hexString.substring(x, x + 2), 16))
	        .mapToObj(x -> (byte) x)
	        .toArray(Byte[]::new);
	}




	
	
	/**
	 * Converts an array of bytes to a hexadecimal string.
	 * @param arr An array of bytes.
	 * @return A hexadecimal string representing the integer values of the bytes in the input array.
	 */
	public static String toHex(byte[] arr) 
	{
	    StringBuilder sb = new StringBuilder(arr.length * 2);
	    for (byte b : arr) 
	    {

	        sb.append(String.format("%02X", b));
	    }
	    return sb.toString();
	}



	
	/**
	 * Determines whether a string consists only of hexadecimal digits.
	 * @param str The string to be checked.
	 * @return `true` if the string consists only of hexadecimal digits, `false` otherwise.
	 */
	public static boolean isHex(String str) 
	{
	    try {
	      toByteArray(str);
	    } catch (Exception e) 
	    {
	      return false;
	    }

	    return true;
	}

	/**
	 * Converts a hexadecimal string to an array of bytes.
	 * @param hexString The hexadecimal string to be converted.
	 * @return An array of bytes representing the hexadecimal string.
	 */
	public static Byte[] toByteArray(String hexString)
	{

	    return IntStream
	        .range(0, hexString.length())
	        .filter(x -> x % 2 == 0)
	        .map(x -> Integer.parseInt(hexString.substring(x, x + 2), 16))
	        .mapToObj(x -> (byte) x)
	        .toArray(Byte[]::new);
	}
	
	/**
	 * Extracts an integer value from an array of bytes.
	 * @param data The array of bytes from which to extract the integer value.
	 * @param offset The starting position in the array from which to extract the integer value.
	 * @param length The number of bytes to use in the extraction.
	 * @return The integer value extracted from the array of bytes.
	 */
	public static int getInt(byte[] data, int offset, int length)
	{
	    int result = 0;
	    for (int i = 0; i < length; i++) 
	    {
	        result = (result << 8) | data[offset + i];
	    }
	    return result;
	}
	
	/**
	 * Converts a hexadecimal string to an ASCII string.
	 *
	 * @param hexString The hexadecimal string to convert.
	 * @return An ASCII string representing the input hexadecimal string.
	 */
	public static String toAscii(String hexString) 
	{
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i <= hexString.length() - 2; i += 2) 
	    {
	        String hexByte = hexString.substring(i, i + 2);
	        sb.append((char) Integer.parseInt(hexByte, 16));
	    }
	    return sb.toString();
	}
	
	/**
	 * Converts a byte array to an integer.
	 * 
	 * @param byteArray The byte array to convert.
	 * @return The integer value stored in the byte array.
	 */
	public static int byteArrayToInteger(byte[] byteArray) 
	{
	    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) 
	    {
	        for (int i = 0; i < byteArray.length / 2; i++) 
	        {
	            byte temp = byteArray[i];
	            byteArray[i] = byteArray[byteArray.length - i - 1];
	            byteArray[byteArray.length - i - 1] = temp;
	        }
	    }
	   	    return ByteBuffer.wrap(byteArray).getInt();
	}
	
	/**
	 * Converts an integer to a byte array.
	 * 
	 * @param value The integer value to convert.
	 * @return The byte array representation of the integer.
	 */
	public static byte[] integerToByteArray(int value) 
	{
	    byte[] intBytes = ByteBuffer.allocate(4).putInt(value).array();
	    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) 
	    {
	        for (int i = 0; i < intBytes.length / 2; i++) 
	        {
	            byte temp = intBytes[i];
	            intBytes[i] = intBytes[intBytes.length - i - 1];
	            intBytes[intBytes.length - i - 1] = temp;
	        }
	    }
	    return intBytes;
	}
	
	/**
	 * Converts a list of strings to a byte array.
	 * 
	 * @param array The list of strings to convert.
	 * @param itemMaxCount The maximum number of items in the list.
	 * @param itemMaxLength The maximum length of each item in the list.
	 * @return The byte array representation of the list of strings.
	 */
	public static byte[] stringListToByteArray(List<String> array, int itemMaxCount, int itemMaxLength) 
	{
	    byte[] outputBytes = new byte[itemMaxCount * itemMaxLength];
	    int index = 0;
	    for (String val : array) 
	    {
	        byte[] valBytes = val.getBytes();
	        System.arraycopy(valBytes, 0, outputBytes, index, valBytes.length);
	        index += itemMaxLength;
	    }
	    return outputBytes;
	}
	
	/**
	 * Converts a byte array to a list of strings.
	 * 
	 * @param byteArray The byte array to convert.
	 * @param itemMaxCount The maximum number of items in the list.
	 * @param itemMaxLength The maximum length of each item in the list.
	 * @return The list of strings stored in the byte array.
	 */
	public static List<String> byteArrayToStringList(byte[] byteArray, int itemMaxCount, int itemMaxLength) 
	{
	    List<String> list = new ArrayList<String>();
	    for (int i = 0; i < itemMaxCount; i++) 
	    {
	        byte[] itemBytes = new byte[itemMaxLength];
	        System.arraycopy(byteArray, i * itemMaxLength, itemBytes, 0, itemMaxLength);
	        String val = new String(itemBytes);
	        if (val != null && !val.isEmpty()) 
	        {
	            list.add(val);
	        }
	    }
	    return list;
	}
	
	/**
	 * Converts a string to a byte array.
	 * 
	 * @param data The string to convert.
	 * @return The byte array representation of the string.
	 */
	public static byte[] stringToByteArray(String data) 
	{
	    return data.getBytes(StandardCharsets.US_ASCII);
	}

	/**
	 * Converts a byte array to a string.
	 * 
	 * @param byteArray The byte array to convert.
	 * @return The string stored in the byte array.
	 */
	public static String byteArrayToString(byte[] byteArray) 
	{

	    return new String(byteArray, StandardCharsets.UTF_8).trim();
	}
}