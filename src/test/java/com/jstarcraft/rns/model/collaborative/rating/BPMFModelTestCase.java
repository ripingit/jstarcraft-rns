package com.jstarcraft.rns.model.collaborative.rating;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

import com.jstarcraft.ai.evaluate.Evaluator;
import com.jstarcraft.ai.evaluate.rating.MAEEvaluator;
import com.jstarcraft.ai.evaluate.rating.MPEEvaluator;
import com.jstarcraft.ai.evaluate.rating.MSEEvaluator;
import com.jstarcraft.core.utility.Configurator;
import com.jstarcraft.rns.task.RatingTask;

import it.unimi.dsi.fastutil.objects.Object2FloatSortedMap;

public class BPMFModelTestCase {

    @Test
    public void testRecommender() throws Exception {
        Properties keyValues = new Properties();
        keyValues.load(this.getClass().getResourceAsStream("/data/filmtrust.properties"));
        keyValues.load(this.getClass().getResourceAsStream("/model/collaborative/rating/bpmf-test.properties"));
        Configurator configuration = new Configurator(keyValues);
        RatingTask job = new RatingTask(BPMFModel.class, configuration);
        Object2FloatSortedMap<Class<? extends Evaluator>> measures = job.execute();
        Assert.assertEquals(0.665037F, measures.getFloat(MAEEvaluator.class), 0F);
        Assert.assertEquals(0.9846474F, measures.getFloat(MPEEvaluator.class), 0F);
        Assert.assertEquals(0.70209664F, measures.getFloat(MSEEvaluator.class), 0F);
    }

}
