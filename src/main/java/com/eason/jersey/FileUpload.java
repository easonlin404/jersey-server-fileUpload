package com.eason.jersey;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author Eason Lin
 *
 */
@Path("/upload")
public class FileUpload {

	/**
	 *
	 * @param uploadedInputStream
	 * @param fileDetail
	 * @return
	 * @throws Exception
	 */
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public  Map<String, Object> upload(
			@FormDataParam("declNo") String declNo,
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) throws Exception {
		try {

			if (fileDetail == null)
				throw new IllegalArgumentException("fileDetail is null");
			if (uploadedInputStream == null)
				throw new IllegalArgumentException(
						"uploadedInputStream is null");

			File temp = File.createTempFile("temp-file", ".tmp");
			System.out.println(temp.getAbsolutePath());
			writeToFile(uploadedInputStream, temp);

			// TODO: do something
			 Map<String, Object> map = new HashMap<String, Object>();
			 map.put("msg", "success");
			return map;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream, File target) {
		int read = 0;
		byte[] bytes = new byte[1024];

		try {
			OutputStream out = new FileOutputStream(target);
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
