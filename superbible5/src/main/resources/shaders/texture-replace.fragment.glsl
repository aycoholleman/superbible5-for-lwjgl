#version 430 core

in vec2 vTex;
uniform sampler2D textureUnit0;

out vec4 color;

void main(void) 
{
	color = texture2D(textureUnit0, vTex); 
}
