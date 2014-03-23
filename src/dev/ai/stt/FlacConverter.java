package dev.ai.stt;

import java.io.File;

import dev.ai.HostInfo;
import javaFlacEncoder.FLAC_FileEncoder;

public class FlacConverter {

	public FlacConverter(){
		FLAC_FileEncoder ffe = new FLAC_FileEncoder();
	    ffe.encode(new File(System.getProperty(HostInfo.OS_TEMP_PATH_LOC)+""+"\\audio.wav"), new File(System.getProperty(HostInfo.OS_TEMP_PATH_LOC)+""+"\\audio.flac"));
	}
}
