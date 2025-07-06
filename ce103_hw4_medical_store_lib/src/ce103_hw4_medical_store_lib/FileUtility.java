package ce103_hw4_medical_store_lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class FileUtility 
{
	/**
	 * Deletes a file at the specified path.
	 * 
	 * @param path The path of the file to delete.
	 * @return True if the file was successfully deleted, false otherwise.
	 */
	public static boolean deleteFile(String path) 
	{
	    if (new File(path).exists()) 
	    {
	        new File(path).delete();
	    }

	    return true;
	}
	
	/**
	 * Reads a block of bytes from a file at the specified path.
	 * 
	 * @param count The block number to read (1-based).
	 * @param blockSize The size of each block in bytes.
	 * @param path The path of the file to read from.
	 * @return The byte array containing the block of data read from the file.
	 * @throws IOException If an I/O error occurs while reading the file.
	 */
	public static byte[] readBlock(int count, int blockSize, String path) throws IOException 
	{
	    // Create a buffer array to hold the block of data
	    byte[] buffer = new byte[blockSize];

	    // Open a FileInputStream for the specified file
	    try (FileInputStream fileInputStream = new FileInputStream(path)) 
	    {
	        // Move the stream pointer to the beginning of the desired block
	        fileInputStream.skip((count - 1) * blockSize);
	        
	        // Read the block of data into the buffer array
	        fileInputStream.read(buffer, 0, buffer.length);
	    }

	    // Return the buffer array
	    return buffer;
	}


	/**
	 * Appends a block of data to a file at the specified path.
	 * 
	 * @param data The data to append to the file.
	 * @param path The path of the file to append to.
	 * @return True if the data was successfully appended to the file, false otherwise.
	 * @throws IOException If an I/O error occurs while writing to the file.
	 */
	public static boolean appendBlock(byte[] data, String path) throws IOException 
	{
	    // Open a FileOutputStream for the specified file
	    try (FileOutputStream fileOutputStream = new FileOutputStream(path, true)) 
	    {
	        // Append the data to the file
	        fileOutputStream.write(data);
	    }

	    // Return true
	    return true;
	}
	
	
	/**
	 * Updates a block of data in a file at the specified path.
	 * 
	 * @param data The data to update in the file.
	 * @param count The block number to update (1-based).
	 * @param blockSize The size of each block in bytes.
	 * @param path The path of the file to update.
	 * @return True if the data was successfully updated in the file, false otherwise.
	 * @throws IOException If an I/O error occurs while writing to the file.
	 */
	public static boolean updateBlock(byte[] data, int count, int blockSize, String path) throws IOException
	{
	    // Open a FileOutputStream for the specified file
	    try (FileOutputStream fileOutputStream = new FileOutputStream(path)) 
	    {
	        // Move the stream pointer to the beginning of the block to be updated
	        fileOutputStream.getChannel().position((count - 1) * blockSize);
	        
	        // Write the updated block data to the file
	        fileOutputStream.write(data);
	    }

	    // Return true
	    return true;
	}

	/**
	 * Deletes a block of data from a file at the specified path.
	 * 
	 * @param count The block number to delete (1-based).
	 * @param blockSize The size of each block in bytes.
	 * @param path The path of the file to delete from.
	 * @return True if the data was successfully deleted from the file, false otherwise.
	 * @throws IOException If an I/O error occurs while writing to the file.
	 */
	public static boolean deleteBlock(int count, int blockSize, String path) throws IOException 
	{
	    byte[] data = new byte[blockSize];

	    try (FileOutputStream fileOutputStream = new FileOutputStream(path)) 
	    {
	        fileOutputStream.getChannel().position((count - 1) * blockSize);
	        fileOutputStream.write(data);
	    }

	    return true;
	}
}
