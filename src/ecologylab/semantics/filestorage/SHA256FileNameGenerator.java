/**
 * 
 */
package ecologylab.semantics.filestorage;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import ecologylab.net.ParsedURL;

/**
 * file name generator for filesystem storage of downloaded resource
 * 
 * @author ajit
 *
 */

public class SHA256FileNameGenerator
{
	public static String getName(ParsedURL originalPURL)
	{
		String OUT_PREFIX = "nwDownloaded";
		// String OUT_SUFFIX = ".html";

		MessageDigest md;
		try
		{
			md = MessageDigest.getInstance("SHA-256");
			md.update(originalPURL.toString().getBytes("UTF-8")); // Change this to "UTF-16" if needed
			byte[] digest = md.digest();
			
			// Using Arrays.toString doesn't look very good.
			// Please change to something like:
//			char[] hex = "0123456789ABCDEF".toCharArray();  // this should go static
//			StringBuilder sb = StringBuilderUtils.acquire();
//			for (byte b : digest)
//			{
//				sb.append(hex[(b & 0xF0) >> 4]);
//				sb.append(hex[b & 0x0F]);
//			}
//			String hashStr = sb.toString();
//			StringBuilderUtils.release(sb);
			String hashStr = Arrays.toString(digest);

			OUT_PREFIX = hashStr.substring(1, (hashStr.length() - 1));
			OUT_PREFIX = OUT_PREFIX.replace(", ", "");
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		// suffix based on contentType
		// if (mimeType != null && mimeType.equals("text/xml"))
		// OUT_SUFFIX = ".xml";

		String OUT_NAME = OUT_PREFIX; // + OUT_SUFFIX;
		return OUT_NAME;
	}
}