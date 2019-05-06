package org.polymodel.prdg.adapter;

import java.io.File;

import org.polymodel.prdg.PRDG;
import org.polymodel.prdg.adapter.model.IPRDGAdapter;

public class PRDGToDotty {

	public static void process(PRDG prdg, String filePath) {
		File f = new File(filePath);
		f.mkdirs();
		f.delete();
		IPRDGAdapter adapter = PRDGAdapterComponent.INSTANCE.build(prdg);
		PRDGAdapterComponent.INSTANCE.getGraphExportService().export(filePath, adapter);
	}
}
