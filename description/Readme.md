# Criação da tela do jogo
## Nesta primeira etapa iniciaremos a criação da tela do jogo, o tamanho da janela e algumas funções especiais. 

+ Instanciaremos o objeto para criarmos a janela.
+ Diremos que a janela será encerrada apenas quando clicamos no "x".
+ Diremos que a janela não é redimensionável.
+ O título da nossa janela.
+ A posição que a janela iniciará será false, isso quer dizer que a janela começará no centro da tela.

```java
JFrame window = new JFrame();
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setResizable(false);
window.setTitle("2D Adventure");
        
window.setLocationRelativeTo(null);
window.setVisible(true);
```

## Nessa segunda etapa definiremos as configurações da tela, seu tamanho, cor, etc.

+ Criaremos uma classe chamada `gamePanel` que herda as propriedades de `JPanel`
+ Definimos o tamanho dos pixeis sendo 16x16, assim os personagens, objetos terão por padrão tamanho 16x16.
+ Definimos a escala sendo 3x, pois para a resolução atual dos computadores(superiores a 1280 x 960) personagens ou tiles de 16x16 pixeis seriam muito pequenos para a tela.
+ Depois fazemos um comando para dizer que agora o tamanho dos pixeis é de 48x48 (16 x 3).

```java
final int originalTileSize = 16;
final int scale = 3;

final int tileSize = originalTileSize * scale; // 48x48 tile
```

Aqui decidiremos o tamanho da tela definindo primeiro quantos tiles serão exibidos horizontal e verticalmente

```java
final int maxScreenCol = 16;
final int maxScreenRow = 12;
// Tendo 16 tiles na horizontal e 12 na vertical chegamos na resolução de 4:3
final int screenWidth = tileSize * maxScreenCol; // 768 pixels
final int screenHeight = tileSize * maxScreenRow; // 576 pixels
// Já que um único tile possui 48 pixeis, 16 tiles na horizontal e 12 na vertical teremos respetivamente 768 e 576 pixeis.
```
Criamos um construtor para aplicarmos as nossas configurações de tela
+ Define o tamanho da tela
+ A cor inicial 
+ Melhora a renderização do jogo 
```java
public GamePanel() {
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);

    this.setDoubleBuffered(true);
}
```
## Agora faremos as aplicações em nossa classe principal, instanciando primeiramente a classe que criamos.
+ Esse comando faz com que adicionemos as mudanças feitas na nossa classe para uma tela
+ Faz com que esta janela seja dimensionada para se ajustar ao tamanho e aos layouts preferidos dos seus subcomponentes.
```java
GamePanel gamePanel = new GamePanel();
window.add(gamePanel);

window.pack(); // para esse comando funcionar precisariamos do window.add para puxar as modificações que fizemos na nossa classe gamePanel
```
## Nesta etapa começaremos a introduzir as animações que o nosso personagem, inimigos e outros Npcs farão.   
+ Para criar essa mecânica precisaremos de uma classe chamada `thread`
- O `thread` fará com que o programa continue a rodar até decidirmos pará-lo, muito útil quando queremos que algo se repita como fazer animações sprites.
```java
Thread gameThread;
public void run() { // Método que precisa ser implementado com a classe. Esse método ele será ativado toda vez que usarmos um thread

}
```
Para finalizarmos esta parte criaremos um método para instanciar o thread e passar a nossa classe atual para o seu construtor.

```java
public void startGameThread() {
    gameThread = new Thread(this);
    gameThread.start();
}
```