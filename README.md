# ES-IVFPQ Plugin

## Installations

### Install Java 17

```sh
sudo apt update && sudo apt install -y openjdk-17-jdk
```

Set `JAVA_HOME` in `~/.bashrc`:

```sh
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
```

Check version:

```sh
java -version
javac -version
```

### Install gradle

```sh
cd downloads
wget https://githubfast.com/gradle/gradle-distributions/releases/download/v8.14.1/gradle-8.14.1-bin.zip
unzip gradle-8.14.1-bin.zip -d ~
```

Add following line to `~/.bashrc`:

```sh
export PATH=$HOME/gradle-8.14.1/bin:$PATH
```

Check version:

```sh
gradle -v
```

## Build commands

```sh
gradle wrapper --gradle-version 8.14.1
```

```sh
./gradlew clean assemble
# ./gradlew --refresh-dependencies clean assemble
```

## Load commands

See: [`load.sh`](./load.sh)

Load plugin to elasticsearch:

```sh
./load.sh
```

Check if plugin is loaded:

```sh
curl --cacert $HOME/elasticsearch-docker/certs/ca/ca.crt -u elastic:$ELASTIC_PASSWORD -X GET "https://localhost:19200/_cat/plugins?v"
```

## References

### IVF-PQ

* Product Quantization: Compressing high-dimensional vectors by 97% | Pinecone
  * https://www.pinecone.io/learn/series/faiss/product-quantization

* IVFPQ - LanceDB --- IVFPQ - LanceDB
  * https://lancedb.github.io/lancedb/concepts/index_ivfpq

* Facebook AI and the Index Factory | Pinecone
  * https://www.pinecone.io/learn/series/faiss/composite-indexes

* Inverted File Product Quantization (IVF_PQ): Accelerate vector search by creating indices | by Prashant Dixit | LanceDB | Medium
  * https://medium.com/etoai/product-quantization-compress-high-dimensional-vectors-dfcba98fab47

* matsui528/nanopq: Pure python implementation of product quantization for nearest neighbor search
  * https://github.com/matsui528/nanopq/tree/main

* Deep Dive into Faiss IndexIVFPQ for vector search | siddharth's space
  * https://sidshome.wordpress.com/2023/12/30/deep-dive-into-faiss-indexivfpq-for-vector-search

* IVF-PQ — cuvs
  * https://docs.rapids.ai/api/cuvs/stable/indexes/ivfpq/


### Faiss

* Implementation notes · facebookresearch/faiss Wiki
  * https://github.com/facebookresearch/faiss/wiki/Implementation-notes

* Indexing 1G vectors · facebookresearch/faiss Wiki
  * https://github.com/facebookresearch/faiss/wiki/Indexing-1G-vectors

* Special operations on indexes · facebookresearch/faiss Wiki
  * https://github.com/facebookresearch/faiss/wiki/Special-operations-on-indexes?utm_source=chatgpt.com

* faiss/faiss/impl/ProductQuantizer.cpp at main · facebookresearch/faiss
  * https://github.com/facebookresearch/faiss/blob/main/faiss/impl/ProductQuantizer.cpp

* faiss/tutorial/python/3-IVFPQ.py at main · facebookresearch/faiss
  * https://github.com/facebookresearch/faiss/blob/main/tutorial/python/3-IVFPQ.py


### Elastic Plugin

* Creating text analysis plugins with the stable plugin API | Elastic Documentation
  * https://www.elastic.co/docs/extend/elasticsearch/creating-stable-plugins
  * https://www.elastic.co/docs/extend/elasticsearch/plugin-descriptor-file-stable

* rixwew/elasticsearch-approximate-nearest-neighbor: Plugin to integrate approximate nearest neighbor(ANN) search with Elasticsearch
  * https://github.com/rixwew/elasticsearch-approximate-nearest-neighbor/tree/master
  * https://github.com/rixwew/elasticsearch-approximate-nearest-neighbor/blob/master/README.md
  * https://github.com/rixwew/elasticsearch-approximate-nearest-neighbor/tree/master/src/main/java/org/elasticsearch/analysis

* elasticsearch/plugins/examples/stable-analysis/src/main/java/org/elasticsearch/example/analysis at main · elastic/elasticsearch
  * https://github.com/elastic/elasticsearch/tree/main/plugins/examples/stable-analysis/src/main/java/org/elasticsearch/example/analysis
