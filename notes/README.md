
大量数据的输入输出用
```java
    long now = System.currentTimeMillis();
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < intN; i++) {
        for (int j = 0; j < intM; j++) {
            if (di[i][j]) writer.write('g');
            else writer.write('.');
        }
        writer.write('\n');
    }
    writer.flush();
    System.err.println(System.currentTimeMillis()-now);
```