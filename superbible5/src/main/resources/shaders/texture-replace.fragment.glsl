#version 430 core

in vec2 vTex;
uniform sampler2D textureUnit0;

void main(void) 
{
	gl_FragColor = texture2D(textureUnit0, vTex); 
}
