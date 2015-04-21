#version 430 core

in vec2 vTex;
uniform sampler2DRect textureUnit0;

void main(void) 
{
	gl_FragColor = texture2DRect(textureUnit0, vTex); 
}
