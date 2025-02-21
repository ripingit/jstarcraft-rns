
package com.jstarcraft.rns.model.collaborative.ranking;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

import com.jstarcraft.ai.evaluate.Evaluator;
import com.jstarcraft.ai.evaluate.ranking.AUCEvaluator;
import com.jstarcraft.ai.evaluate.ranking.MAPEvaluator;
import com.jstarcraft.ai.evaluate.ranking.MRREvaluator;
import com.jstarcraft.ai.evaluate.ranking.NDCGEvaluator;
import com.jstarcraft.ai.evaluate.ranking.NoveltyEvaluator;
import com.jstarcraft.ai.evaluate.ranking.PrecisionEvaluator;
import com.jstarcraft.ai.evaluate.ranking.RecallEvaluator;
import com.jstarcraft.core.utility.Configurator;
import com.jstarcraft.rns.task.RankingTask;

import it.unimi.dsi.fastutil.objects.Object2FloatSortedMap;

public class ItemKNNRankingModelTestCase {

    @Test
    public void testRecommenderRanking() throws Exception {
        Properties keyValues = new Properties();
        keyValues.load(this.getClass().getResourceAsStream("/data/filmtrust.properties"));
        keyValues.load(this.getClass().getResourceAsStream("/model/collaborative/itemknnranking-test.properties"));
        Configurator configuration = new Configurator(keyValues);
        RankingTask job = new RankingTask(ItemKNNRankingModel.class, configuration);
        Object2FloatSortedMap<Class<? extends Evaluator>> measures = job.execute();
        Assert.assertEquals(0.8993107F, measures.getFloat(AUCEvaluator.class), 0F);
        Assert.assertEquals(0.35920423F, measures.getFloat(MAPEvaluator.class), 0F);
        Assert.assertEquals(0.49634278F, measures.getFloat(MRREvaluator.class), 0F);
        Assert.assertEquals(0.45277607F, measures.getFloat(NDCGEvaluator.class), 0F);
        Assert.assertEquals(17.380283F, measures.getFloat(NoveltyEvaluator.class), 0F);
        Assert.assertEquals(0.305903F, measures.getFloat(PrecisionEvaluator.class), 0F);
        Assert.assertEquals(0.5471662F, measures.getFloat(RecallEvaluator.class), 0F);
    }

}
