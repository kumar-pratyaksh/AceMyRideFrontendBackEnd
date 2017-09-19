package com.avizva.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DownloadController {
	private final String fileDir = "/tmp/AceMyRide/productImages/";

	private final static Logger LOGGER = LogManager.getLogger();

	@RequestMapping(value = "download", produces = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
	@ResponseBody
	public byte[] downloadFile(@RequestParam(required = true) String fileName) throws IOException {
		InputStream inputStream = new FileInputStream(fileDir + fileName);
		return IOUtils.toByteArray(inputStream);
	}
}
