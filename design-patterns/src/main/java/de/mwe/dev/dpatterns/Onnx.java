package de.mwe.dev.dpatterns;

import ai.onnxruntime.OnnxTensor;
import ai.onnxruntime.OrtEnvironment;
import ai.onnxruntime.OrtException;
import ai.onnxruntime.OrtSession;

public class Onnx {
// D:\\DEV\\java\\dev\\example-projects-java\\design-patterns\\src\\main\\java\\de\\mwe\\dev\\dpatterns\\ssd-12-int8
  public static void main(String[] args) throws OrtException{

    try (OrtEnvironment env = OrtEnvironment.getEnvironment();
             OrtSession.SessionOptions opts = new OrtSession.SessionOptions()) {
            opts.setOptimizationLevel(OrtSession.SessionOptions.OptLevel.BASIC_OPT);

            try (OrtSession session = env.createSession("D:\\DEV\\java\\dev\\example-projects-java\\design-patterns\\src\\main\\java\\de\\mwe\\dev\\dpatterns\\ssd-12-int8.onnx", opts)) {
                var myTensor = OnnxTensor.createTensor(env, 10.0f);
                System.out.println(session.toString());
                System.out.println(session.getMetadata().getProducerName());
                System.out.println(myTensor);
            }
        }catch(Exception e){System.out.println(e);}
  }
}
