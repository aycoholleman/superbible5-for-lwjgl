#version 430 core

uniform sampler2D textureUnit0;

in vec2 vTex;

void main(void) 
{
	gl_FragColor = texture2D(textureUnit0, vTex); 
}
