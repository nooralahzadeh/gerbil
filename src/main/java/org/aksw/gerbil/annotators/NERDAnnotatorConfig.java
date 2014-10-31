package org.aksw.gerbil.annotators;

import it.acubelab.batframework.problems.TopicSystem;

import org.aksw.gerbil.bat.annotator.NERDAnnotator;
import org.aksw.gerbil.config.GerbilConfiguration;
import org.aksw.gerbil.datatypes.ExperimentType;

public class NERDAnnotatorConfig extends AbstractAnnotatorConfiguration {

	public static final String ANNOTATOR_NAME = "NERD";
    private static final String NERD_WEB_SERVICE_KEY_PROPERTY_NAME = "org.aksw.gerbil.annotators.nerd.Key";
	
    public NERDAnnotatorConfig() {
        super(ANNOTATOR_NAME, true, ExperimentType.Sa2W);
    }
	

	@Override
	protected TopicSystem loadAnnotator() throws Exception {
        // Load and use the key if there is one
        String key = GerbilConfiguration.getInstance().getString(NERD_WEB_SERVICE_KEY_PROPERTY_NAME);
        if (key == null) {
        	return null;
        } else {
            return new NERDAnnotator(key);
        }
	}

}